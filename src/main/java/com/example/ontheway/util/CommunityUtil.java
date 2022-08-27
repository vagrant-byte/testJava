package com.example.ontheway.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {
    //生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密 对密码+随机字符串进行加密
    //key 为原始字符串+随机字符串
    public static String md5(String key) {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
    //code 状态码 msg 状态码描述  map信息
    public static String getJSONString(int code, String msg, Map<String,Object> map) {
        JSONObject json=new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        if(map!=null) {
            for (String key:map.keySet()) {
                json.put(key,map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code,msg,null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code,null,null);
    }

    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",23);
        System.out.println(getJSONString(0,"ok",map));
    }
}
