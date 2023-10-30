package com.bayu.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
public record InventoryResponse(
        @JsonProperty(value = "sku_code") String skuCode,
        @JsonProperty(value = "is_ins_stock") boolean isInStock
) {

}
