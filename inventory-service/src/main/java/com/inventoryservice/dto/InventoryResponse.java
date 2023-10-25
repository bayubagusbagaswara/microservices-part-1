package com.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record InventoryResponse(
        @JsonProperty(value = "sku_code") String skuCode,
        @JsonProperty(value = "is_in_stock") boolean isInStock
) {

}
