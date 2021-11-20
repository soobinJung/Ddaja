package com.bng.ddaja.passRate;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;

@AllArgsConstructor
@RequestMapping("pass-rate")
@RestController
public class passRateController {
    
    @GetMapping("")
    public String getPassRate() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.q-net.or.kr/api/service/rest/InquiryEmqualPassSVC/getList"); /*URL*/

        String 디코더인증키 = "X4XLTRWw4t4a+VaeVigQCCvZAR6QPkeH6BuBnmasH8CJUgXNnyYFOlCb6w/IICASjBzGwfju/sKqEL9cENui6w==";
        String 인코더인증키 = "X4XLTRWw4t4a%2BVaeVigQCCvZAR6QPkeH6BuBnmasH8CJUgXNnyYFOlCb6w%2FIICASjBzGwfju%2FsKqEL9cENui6w%3D%3D";
        
        /*Service Key*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + 인코더인증키 ); 

        /*발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(인코더인증키, "UTF-8")); 

        /*등급코드*/
        urlBuilder.append("&" + URLEncoder.encode("grdCd","UTF-8")      + "=" + URLEncoder.encode("10", "UTF-8")); 

        /*통계연도*/
        urlBuilder.append("&" + URLEncoder.encode("baseYY","UTF-8")     + "=" + URLEncoder.encode("2018", "UTF-8")); 

        /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8")     + "=" + URLEncoder.encode("1", "UTF-8")); 

        /*페이지당 데이터 수*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8")  + "=" + URLEncoder.encode("1", "UTF-8")); 

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        System.out.println("Response code: " + conn.getResponseCode());

        StringBuilder sb = new StringBuilder();
        BufferedReader rd;
        String line;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();

        System.out.println(sb.toString());

        return sb.toString();
    }
}