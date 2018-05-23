package com.tmm.Tools;

import java.util.List;
import java.util.Map;

/**
 * Created by Captain Wang on 17/6/17.
 */
public class ApplicationTools {

    public String mapReaderToHtmlText(Map<String, List<String>> map) {
        String str = "";
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            str = str + entry.getKey() + ": " ;
            for(int i=0;i<entry.getValue().size();i++){

                str=str+entry.getValue().get(i)+"<br>";

            }

            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            //System.out.println("key= " + entry.getKey() + " and value= "
            //      + entry.getValue());
        }
        return str;
    }
}
