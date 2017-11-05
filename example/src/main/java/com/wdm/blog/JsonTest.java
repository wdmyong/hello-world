package com.wdm.blog;

/**
 * Created by wdmyong on 2017/10/11.
 */
public class JsonTest {
    private static final String STR = "\"{\\\"clientId\\\":1,\\\"channel\\\":\\\"a\\\",\\\"location\\\":{\\\"lat\\\":39.99274917993132,\\\"lon\\\":116.3252939634231,\\\"valid\\\":true},\\\"deviceId\\\":\\\"F0C620D4-0CEB-48F5-9F6A-9C6FD28EE926\\\",\\\"ip\\\":\\\"10.10.210.22\\\",\\\"net\\\":\\\"中国移动_5\\\",\\\"appVer\\\":\\\"5.3.3.251\\\",\\\"sysVer\\\":10.33,\\\"locale\\\":\\\"zh_CN_#Hans\\\",\\\"phoneModel\\\":\\\"iPhone8,2\\\",\\\"port\\\":0}\"";

    public static void main(String[] args) {
        System.out.println(STR);
    }
}
