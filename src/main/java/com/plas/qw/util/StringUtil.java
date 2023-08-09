package com.plas.qw.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/18/14:23
 * @Description:
 */
public class StringUtil {
    //判空
    public static boolean isNotEmpty(String param){
        return param != null && !"".equals(param.trim());
    }
    //检查匹配
    public boolean checkStr(String inputString){
        String canshu=inputString;
        boolean checkStrReturn=false;
        String pattern=".+";
        Pattern p=Pattern.compile(pattern);
        if(StringUtil.isNotEmpty(pattern)){
            Matcher m=p.matcher(canshu);
            boolean matches = m.matches();
            checkStrReturn=matches;
        }
        return checkStrReturn;
    }
}
