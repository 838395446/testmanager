package com.tmm;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class RetrofitTest_01 {


    @Test
    public void test_01() {
        try{
            String s="";
            Gson gson = new Gson();

            Map<String, Object> map = gson.fromJson(s,Map.class);



            System.out.println(map==null);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
