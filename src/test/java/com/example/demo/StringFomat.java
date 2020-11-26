package com.example.demo;


import org.springframework.util.Base64Utils;

public class StringFomat {


    public static void main(String[] args) {
//        String phone = "12345";
//        String email = "";
//        String pin = "wayne";
//        String sql1 = "update user set csc_phone = '%s',csc_email='%s',email_valid=%d,index_csc_phone='%s',index_csc_email='%s',encrypt_phone='',encrypt_email='' where pin='%s'";
//        String sql2 = "update cloud_user set mobile='%s',phone = '%s',email='%s',index_phone='%s',index_email='%s',encrypt_phone='',encrypt_email='' where pin='%s'";
//        String fomat1 = String.format(sql1, phone, email, email.equals("") ? 0 : 1, phone.equals("") ? "" : DigestUtils.sha256Hex(phone), email.equals("") ? "" : DigestUtils.sha256Hex(email), pin);
//        String fomat2 = String.format(sql2, phone, phone, email, phone.equals("") ? "" : DigestUtils.sha256Hex(phone), email.equals("") ? "" : DigestUtils.sha256Hex(email), pin);
//
//        System.out.println(fomat1);

        //emhhbmd3ZW54dWFu
        System.out.println(Base64Utils.encodeToString("jd_质量测试_wayne".getBytes()));



    }
}
