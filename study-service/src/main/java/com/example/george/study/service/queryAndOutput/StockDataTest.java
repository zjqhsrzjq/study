package com.example.george.study.service.queryAndOutput;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author George
 * @date 2020/4/4 下午5:45
 */
@Component
public class StockDataTest {

    private String alibabaUrl = "http://40.push2his.eastmoney.com/api/qt/stock/kline/get" +
            "?cb=jQuery33108109190110459934_1585991693577&secid=106.BABA" +
            "&ut=fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf2%2Cf3%2Cf4%2Cf5" +
            "&fields2=f51%2Cf52%2Cf53%2Cf54%2Cf55%2Cf56%2Cf57%2Cf58&klt=101&fqt=1&end=20500101&lmt=10&_=1585991693592";

    public List test(){
        RestTemplate restTemplate =new RestTemplate();
        try{
            String response = restTemplate.postForObject(alibabaUrl,String.class,String.class);
            Integer first = response.indexOf("{");
            Integer last = response.lastIndexOf("}");
            response = response.substring(first,last+1);
            JSONObject result = JSON.parseObject(response);
            List data = result.getJSONObject("data").getJSONArray("klines");
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList();
    }

}
