package com.bayu.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Builder
public record OrderLineItemDTO(
        @JsonProperty(value = "id") String id,
        @JsonProperty(value = "sku_code") String skuCode,
        @JsonProperty(value = "price") BigDecimal price,
        @JsonProperty(value = "quantity") Integer quantity
) {

}
