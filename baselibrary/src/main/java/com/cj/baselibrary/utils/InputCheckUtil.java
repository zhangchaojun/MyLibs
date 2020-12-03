package com.cj.baselibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiliangliang on 2016/12/7.
 */
public class InputCheckUtil {

    //ip地址：格式是由“.”分割的四部分，每部分的范围是0-255
    public static String checkIp = "^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$";

    //端口号：0-65535
    public static String checkPort = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5])";

    //邮箱
    public static String checkEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

    //电话号码  "XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
    public static String checkTel = "^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";

    //url
//    public static String checkUrl = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    public static String checkUrl = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$";

    public static String checkZDLJDZ = "(\\d{9})";

    /**
     * 验证输入合法性
     *
     * @param checkStr 验证对象的正则表达式
     * @param input    输入的字符串
     * @return
     */
    public static boolean checkInput(String input, String checkStr) {
        Pattern pa = Pattern.compile(checkStr);
        Matcher matcher = pa.matcher(input);
        return matcher.matches();
    }


    /**
     * 验证端口号合法性
     *
     * @param input 输入的端口号
     * @return
     */
    public static boolean checkInput(String input) {
        int parseInt = Integer.parseInt(input);
        if (parseInt > 0 && parseInt <= 65535) {
            return true;
        }

        return false;
    }
    public static boolean isIP(String input) {
        return checkInput(input, checkIp);
    }

    public static boolean isPORT(String input) {
        return checkInput(input);
    }

    /**
     * 密码校验规则：必须同时字母及数字
     *
     * @param pasd
     * @return
     */
    public static boolean checkPasd(String pasd) {
        // 8到20位数字和字母
        String regex = "^(?![^a-zA-Z]+$)(?!\\D+$).{8,20}$";
        Pattern pa = Pattern.compile(regex);
        Matcher matcher = pa.matcher(pasd);
        return matcher.matches();
    }
}
