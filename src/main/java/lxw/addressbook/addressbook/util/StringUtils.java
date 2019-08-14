package lxw.addressbook.addressbook.util;

public class StringUtils {

    public static boolean isEmpty(String s){
        return s == null || "".equals(s);
    }

    public static boolean isNotEmpty(String s){
        return s!=null && s.length()>0;
    }
}
