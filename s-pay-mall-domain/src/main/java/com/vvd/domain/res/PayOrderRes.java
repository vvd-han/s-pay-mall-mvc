package com.vvd.domain.res;

import com.vvd.common.constants.Constants;
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
public class PayOrderRes {

    private String userId;
    private String orderId;
    private String payUrl;
    private Constants.OrderStatusEnum orderStatusEnum;

}
