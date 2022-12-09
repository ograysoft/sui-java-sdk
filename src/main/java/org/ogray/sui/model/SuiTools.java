package org.ogray.sui.model;

public class SuiTools {
    public static String getTypeShort(String type) {
        if(type==null || type.isEmpty())
            return "";

        int p1 = type.indexOf("<");
        if(p1<0)
            return type;

        String res = type.substring(p1+1);
        int p2 = res.indexOf(">");
        if(p2<0){
            return type;
        }
        res = res.substring(0, p2);
        return res;
    }
}
