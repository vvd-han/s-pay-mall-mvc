package com.vvd.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayOrder {
    private String id;
    private String userId;
    private String productId;
    private String productName;
    private String orderId;
    private Date orderTime;
    private BigDecimal totalAmount;
    private String status;
    private String payUrl;
    private Date payTime;
    private Date createTime;
    private Date updateTime;
}
