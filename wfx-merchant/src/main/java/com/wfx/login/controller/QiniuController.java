package com.wfx.login.controller;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/qiniu")
@CrossOrigin
public class QiniuController {

    //...生成上传凭证，然后准备上传
    @Value("${qiniu.ak}")
    private  String accessKey ;
    @Value("${qiniu.sk}")
    private  String secretKey ;
    @Value("${qiniu.bucket}")
    private  String bucket ;
    @Value("${qiniu.baseURL}")
    private  String BasePath ;



    @PostMapping("upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {

        try {
            //1：获取文件字节数组
            byte[] bytes = file.getBytes();
            //2：上传到七牛玉
            //！！！！！！！！！！！！【千万注意你的bucket在哪个区就必须填写哪个区】！！！！！！！！！
            Configuration cfg = new Configuration(Region.huanan());
            //...其他参数参考类注释
            UploadManager uploadManager = new UploadManager(cfg);
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String key = null;

            try {

                Auth auth = Auth.create(accessKey, secretKey);
                String upToken = auth.uploadToken(bucket);

                try {
                    Response response = uploadManager.put(bytes, key, upToken);
                    //解析上传成功的结果
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    System.out.println(putRet.key);
                    System.out.println(putRet.hash);
                    Result<String> stringResult = new Result<>();
                    stringResult.setSuccess(true);
                    stringResult.setMsg("上传成功");
                    stringResult.setData(BasePath+putRet.hash);
                    System.out.println("---------+"+"图片上传成功");
                    return stringResult;
                } catch (QiniuException ex) {
                    ex.printStackTrace();
                    return  new Result<>(false,"上传到图片服务器失败");
                }
            } catch (Exception ex) {
                return  new Result<>(false,"七牛云有问题");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result<>(false,"文件有问题");
        }
    }

}