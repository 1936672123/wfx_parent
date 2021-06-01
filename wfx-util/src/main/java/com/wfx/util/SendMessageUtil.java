package com.wfx.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendMessageUtil {

    @Value("${ali.url}")
    public static String url="http://gw.api.taobao.com/router/rest";
    @Value("${ali.appkey}")
    public static String appkey="23473071";
    @Value("${ali.secret}")
    public static String secret="951efdcc9540d2c0c1646ed6d74892e6";


    public static void sendMsg(String phone, String content) {
        DefaultTaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("问道学院");
        req.setSmsParamString("{\"code\":\"" + content + "\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_127820118");

        try {
            AlibabaAliqinFcSmsNumSendResponse rsp = (AlibabaAliqinFcSmsNumSendResponse) client.execute(req);
            System.out.println(rsp.isSuccess());
        } catch (ApiException arg10) {
            arg10.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendMessageUtil.sendMsg("13476752370", "666");
    }


}