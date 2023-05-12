package com.ming.logistics.utils;

import java.security.MessageDigest;

public class MD5 {

    public String encode(String str) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            result = md.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }

    /**
     * 将二进制转换成十六进制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    public String twoCode(String str){
        MD5 md5 = new MD5();
        String oneCode = md5.encode(str);
        String twoCode = md5.encode(oneCode);

        return twoCode;
    }

    public static void main(String[] args) {
        MD5 md5=new MD5();
        md5.encode("1");
        String content = "1";
        String encoding = md5.encode("root");
        System.out.println(encoding);


    }
}
