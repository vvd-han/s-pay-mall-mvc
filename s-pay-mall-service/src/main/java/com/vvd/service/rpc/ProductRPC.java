package com.vvd.service.rpc;

import com.vvd.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 23:43
 */
@Service
public class ProductRPC {
    public ProductVO queryProductByProductId(String productId) {
        ProductVO productVO = new ProductVO();
        productVO.setProductId(productId);
        productVO.setProductName("测试商品");
        productVO.setProductDesc("这是一个测试商品");
        productVO.setPrice(new BigDecimal("0.01"));
        return productVO;
    }
}
