package com.vvd.service;

import com.vvd.domain.req.ShopCartReq;
import com.vvd.domain.res.PayOrderRes;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:43
 */
public interface IOrderService {

    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

}
