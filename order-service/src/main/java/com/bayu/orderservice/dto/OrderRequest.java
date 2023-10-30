package com.bayu.orderservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(
        List<OrderLineItemDTO> orderLineItemDTOList
) {

}
