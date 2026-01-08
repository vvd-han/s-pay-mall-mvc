package com.vvd.domain.res;

import lombok.Data;

/**
 * @author vvd
 * @description
 * @create 2026-01-06 20:15
 */
@Data
public class WeixinQrCodeRes {
    private String ticket;
    private Long expire_seconds;
    private String url;
}
