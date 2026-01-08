package com.vvd.service.weixin;

import com.vvd.domain.vo.WeixinTemplateMessageVO;
import com.vvd.domain.req.WeixinQrCodeReq;
import com.vvd.domain.res.WeixinQrCodeRes;
import com.vvd.domain.res.WeixinTokenRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;

/**
 * @author vvd
 * @description 微信Api服务 retrofit2
 * @create 2026-01-06 17:24
 */
public interface IWeixinApiService {

    /**
     * 获取微信token
     *
     * @param grantType 授权类型，固定值为"client_credential"
     * @param appId     微信公众号或小程序的appid
     * @param secret    微信公众号或小程序的密钥
     * @return 返回微信access_token的JSON字符串
     */
    @GET("cgi-bin/token")
    Call<WeixinTokenRes> getToken(@Query("grant_type") String grantType,
                                  @Query("appid") String appId,
                                  @Query("secret") String secret) throws IOException;

    /**
     * 获取凭据 ticket
     * 文档：<a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html">Generating_a_Parametric_QR_Code</a>
     * <a href="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET">前端根据凭证展示二维码</a>
     *
     * @param accessToken     getToken 获取的 token 信息
     * @param weixinQrCodeReq 入参对象
     * @return 应答结果
     */
    @POST("cgi-bin/qrcode/create")
    Call<WeixinQrCodeRes> createQrCode(@Query("access_token") String accessToken, @Body WeixinQrCodeReq weixinQrCodeReq);

    /**
     * 发送微信公众号模板消息
     * 文档：<a href="https://mp.weixin.qq.com/debug/cgi-bin/readtmpl?t=tmplmsg/faq_tmpl">...</a>
     *
     * @param accessToken             getToken 获取的 token 信息
     * @param weixinTemplateMessageVO 入参对象
     * @return 应答结果
     */
    @POST("cgi-bin/message/template/send")
    Call<Void> sendMessage(@Query("access_token") String accessToken, @Body WeixinTemplateMessageVO weixinTemplateMessageVO);
}
