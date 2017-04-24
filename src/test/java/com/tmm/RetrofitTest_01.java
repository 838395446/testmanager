package com.tmm;

import com.tmm.domain.BaseUrl;
import com.tmm.domain.TestGroup;
import com.tmm.domain.TestProject;
import com.tmm.service.BaseUrlRepository;
import com.tmm.service.TestGroupRespository;
import com.tmm.service.TestProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Captain Wang on 17/4/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitTest_01 {


    @Autowired
    private BaseUrlRepository baseUrlRepository;

    @Autowired
    private TestGroupRespository testGroupRespository;

    @Autowired
    private TestProjectRepository testProjectRepository;

    @Test
    public void test_01() {

        String s = "string=12=3;name=wangwei;age=26;";

        Map<String, Object> map = new HashMap<String, Object>();

        String[] str = s.split(";");
        if (str[str.length - 1].equals(";")) {
            str[s.length() - 1].replace(";", "");
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);

            System.out.println(str[i].substring(0, str[i].indexOf("=")));
            System.out.println(str[i].substring(str[i].indexOf("=") + 1));
            System.out.println("---------");
            map.put(str[i].substring(0, str[i].indexOf("=")), str[i].substring(str[i].indexOf("=") + 1));

        }
        System.out.println(map);
        System.out.println(map.get("age").getClass());
        System.out.println(map.get("name").getClass());
    }


    @Test
    public void test_02() {


        BaseUrl baseUrl = new BaseUrl();
        baseUrl.setBaseurl("http://localhost:8080");
        baseUrl.setComment("this is comment! ");

        //baseUrlRepository.save(baseUrl);


        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日

        baseUrl.setCreateDate(new Date());
        baseUrl.setLastUpdateDate(new Date());
        baseUrl.setCreateTime(new Date());
        baseUrl.setLastUpdateTime(new Date());

        baseUrl.setProjectId(100001L);


        baseUrlRepository.save(baseUrl);

        System.out.println(df1.format(date));

        DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
        System.out.println(df2.format(date));

        DateFormat df3 = DateFormat.getTimeInstance();//只显示出时分秒
        System.out.println(df3.format(date));

    }

    @Test
    public void test_03() {
        TestGroup testGroup = new TestGroup();

        testGroup.setComment("备注");
        testGroup.setProjectId(100001L);


        testGroup.setTitle("新增接口测试");
        testGroup.setParameters("id=100;name=wang;");
        testGroup.setCreateDate(new Date());
        testGroup.setLastUpdateDate(new Date());
        testGroup.setCreateTime(new Date());
        testGroup.setLastUpdateTime(new Date());

        testGroupRespository.save(testGroup);

    }

    @Test
    public void test_04() {
        TestProject testProject= new TestProject();
        testProject.setComment("zhe是备注");
        testProject.setTitle("酒店项目");
        testProject.setLastUpdateDate(new Date());
        testProject.setCreateDate(new Date());
        testProject.setCreateTime(new Date());
        testProject.setLastUpdateTime(new Date());
        testProjectRepository.save(testProject);
    }
}