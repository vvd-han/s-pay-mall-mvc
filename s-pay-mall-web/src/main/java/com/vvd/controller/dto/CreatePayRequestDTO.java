package com.vvd.controller.dto;

import lombok.Data;

/**
 * @author vvd
 * @description
 * @create 2026-01-09 16:45
 */
@Data
public class CreatePayRequestDTO {

    // 用户ID 【实际产生中会通过登录模块获取，不需要透彻】
    private String userId;
    // 产品编号
    private String productId;

}
