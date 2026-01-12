package com.vvd.dao;

import com.vvd.domain.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:32
 */
@Mapper
public interface IOrderDao {

    void insert(PayOrder payOrder);

    PayOrder queryUnPayOrder(PayOrder payOrder);

    void updateOrderPayInfo(PayOrder payOrder);

    void changeOrderPaySuccess(PayOrder order);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

}