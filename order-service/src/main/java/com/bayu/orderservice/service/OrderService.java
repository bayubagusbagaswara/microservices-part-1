package com.bayu.orderservice.service;

import com.bayu.orderservice.dto.InventoryResponse;
import com.bayu.orderservice.dto.OrderLineItemDTO;
import com.bayu.orderservice.dto.OrderRequest;
import com.bayu.orderservice.model.Order;
import com.bayu.orderservice.model.OrderLineItem;
import com.bayu.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    @Value("${url.api.inventory}")
    private static String apiInventoryURL; // http://localhost:8082/api/inventory

    // ketika customer mau membuat pesanan (order)
    // maka perlu cek stock di inventory-service, apakah stock masih ada

    public void placeOrder(OrderRequest orderRequest) {
        /**
         * Order Request mengirim data
         * skuCode,
         * price,
         * quantity
         * data-data skuCode dan price harusnya didapatkan dari product-service. Sedangkan quantity adalah jumlah yang ingin dibeli
         */
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
        // URL ini untuk mengecek quantity di apakah masih tersedia atau tidak
        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri(apiInventoryURL,
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        for (InventoryResponse inventoryResponse : inventoryResponsesArray) {
            log.info("Inventory SKU Code : {}", inventoryResponse.skuCode());
            log.info("Inventory Stock : {}", inventoryResponse.isInStock());
        }

        // stream data isInStock
        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponsesArray))
                .allMatch(InventoryResponse::isInStock);

        // if result = true, then save the order, if else then throw error
        if (Boolean.TRUE.equals(allProductsInStock)) {
            // jika stock product masih tersedia
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
