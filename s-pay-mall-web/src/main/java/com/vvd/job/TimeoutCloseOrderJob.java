package com.vvd.job;

import com.vvd.dao.IOrderDao;
import com.vvd.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author vvd
 * @description 超时关单
 * @create 2026-01-11 22:38
 */
@Slf4j
@Component
public class TimeoutCloseOrderJob {

    @Resource
    private IOrderService orderService;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void exec() {
        try {
            log.info("任务：超时30分钟，订单关闭");
            List<String> orderIds = orderService.queryTimeoutCloseOrderList();
            if(orderIds == null || orderIds.isEmpty()){
                log.info("暂无超时订单");
                return;
            }
            for (String orderId : orderIds) {
                orderService.changeOrderClose(orderId);
            }
        } catch (Exception e) {
            log.error("任务：超时关单异常！！！", e);
        }
    }
}
