package com.vvd.service.impl;

import com.vvd.common.constants.Constants;
import com.vvd.dao.IOrderDao;
import com.vvd.domain.po.PayOrder;
import com.vvd.domain.req.ShopCartReq;
import com.vvd.domain.res.PayOrderRes;
import com.vvd.domain.vo.ProductVO;
import com.vvd.service.IOrderService;
import com.vvd.service.rpc.ProductRPC;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author vvd
 * @description
 * @create 2026-01-08 22:56
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;

    @Resource
    private ProductRPC productRPC;

    @Override
    public PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception {
        // 1. 查询当前用户是否存在未支付订单或掉单订单
        PayOrder payOrderReq = new PayOrder();
        payOrderReq.setUserId(shopCartReq.getUserId());
        payOrderReq.setProductId(shopCartReq.getProductId());

        PayOrder unpaidOrder = orderDao.queryUnPayOrder(payOrderReq);
        if (unpaidOrder != null && unpaidOrder.getStatus().equals(Constants.OrderStatusEnum.PAY_WAIT.getCode())) {
            log.info("存在未支付订单, 请您先处理。userId:{} produetId:{} orderId:{}", shopCartReq.getUserId(), shopCartReq.getProductId(), unpaidOrder.getOrderId());
            return PayOrderRes.builder()
                    .orderId(unpaidOrder.getOrderId())
                    .payUrl(unpaidOrder.getPayUrl())
                    .build();
        } else if (unpaidOrder != null && unpaidOrder.getStatus().equals(Constants.OrderStatusEnum.CREATE.getCode())) {
            // todo
        }

        // 2. 查询商品 & 创建订单
        ProductVO productVO = productRPC.queryProductByProductId(shopCartReq.getProductId());
        String orderId = RandomStringUtils.randomNumeric(16);
        orderDao.insert(PayOrder.builder()
                .userId(shopCartReq.getUserId())
                .productId(shopCartReq.getProductId())
                .productName(productVO.getProductName())
                .orderId(orderId)
                .totalAmount(productVO.getPrice())
                .orderTime(new Date())
                .status(Constants.OrderStatusEnum.CREATE.getCode())
                .build()
        );
        // 3. 创建支付单
        // todo

        return PayOrderRes.builder()
                .orderId(orderId)
                .payUrl("暂无")
                .build();
    }
}
