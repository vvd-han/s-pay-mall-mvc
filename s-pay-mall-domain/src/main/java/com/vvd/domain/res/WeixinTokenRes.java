package com.vvd.domain.res;

import lombok.Data;

/**
 * @author vvd
 * @description
 * @create 2026-01-06 19:44
 */
@Data
public class WeixinTokenRes {
    private String access_token;
    private int expires_in;
    private String errcode;
    private String errmsg;
}
