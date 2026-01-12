package com.vvd.service;

import com.vvd.domain.req.ShopCartReq;
import com.vvd.domain.res.PayOrderRes;

import java.util.List;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:43
 */
public interface IOrderService {

    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

}
