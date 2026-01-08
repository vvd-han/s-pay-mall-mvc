package com.vvd.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartReq {

    private String userId;
    private String productId;

}
