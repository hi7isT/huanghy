package com.huanghy.utils;

import java.security.MessageDigest;

/**
 * <pre>
 *     MD5加密工具类.
 *     支持加密字符串
 *</pre>
 */

public class MD5Utils {

    public static void main(String[] args) throws Exception{
        String md5 = MD5Utils.md5("123456");//huanghy密码
        System.out.println(md5);
    }

    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * MD5方法
     *
     * @param text 明文
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text){
        String encodeStr = null;
        try {
            //加密后的字符串
            encodeStr=encode(text);
            System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        } catch (Exception e) {

        }

        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5 数据库获取到的加密密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }

    /**  
    * MD5加密.<br>
    * @param  text 要加密的字符串
    * @return   加密后的字符串
    */
    private static String encode(String text) {
        return encode(text,null);
    }

    /**
     * MD5加密
     * @param text 要加密的字符串
     * @param charsetname 字符编码
     * @return  加密后的字符串
     */
    private static String encode(String text, String charsetname){
        String resultString = null;
        try{
            resultString = new String(text);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if(null == charsetname || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }else{
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        }catch (Exception e){
        }
        return resultString;
    }


    public static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }


}
