package com.bayu.orderservice.service;

import com.bayu.orderservice.dto.InventoryResponse;
import com.bayu.orderservice.dto.OrderLineItemDTO;
import com.bayu.orderservice.dto.OrderRequest;
import com.bayu.orderservice.model.Order;
import com.bayu.orderservice.model.OrderLineItem;
import com.bayu.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    @Value("${url.api.inventory}")
    private static String apiInventoryURL; // http://localhost:8082/api/inventory

    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();

        List<OrderLineItem> orderLineItems = orderRequest.orderLineItemDTOList().stream()
                .map(this::mapFromOrderLineItemsDTO)
                .toList();

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        // Call Inventory Service, and place if product is in
        // stock
        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri(apiInventoryURL,
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        // stream data isInStock
        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponsesArray))
                .allMatch(InventoryResponse::isInStock);

        // if result = true, then save the order, if else then throw error
        if (Boolean.TRUE.equals(allProductsInStock)) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItem mapFromOrderLineItemsDTO(OrderLineItemDTO orderLineItemDTO) {
        return OrderLineItem.builder()
                .price(orderLineItemDTO.price())
                .quantity(orderLineItemDTO.quantity())
                .skuCode(orderLineItemDTO.skuCode())
                .build();
    }

}
