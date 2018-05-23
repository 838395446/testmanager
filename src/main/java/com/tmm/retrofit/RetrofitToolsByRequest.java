package com.tmm.retrofit;

import com.tmm.Tools.ApplicationTools;
import com.tmm.dto.Request.CaseStepByRequest;
import com.tmm.dto.Response.RequestInfo;
import com.tmm.dto.Response.ResponseInfo;
import com.tmm.dto.Response.ResponseResult;
import com.tmm.retrofit.config.ConfigValue;
import com.tmm.retrofit.config.RequestMethods;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class RetrofitToolsByRequest {

    private CaseStepByRequest caseStepByRequest;
    private Response<String> re;
    private RequestMethods request;
    private Retrofit retrofit;
    private Call<String> requestCall;
    private String errorMassage;
    private String method;
    private String MsgHeather;

    public void RetrofitBuilder() {
        try {

            retrofit = new Retrofit.Builder()
                    .baseUrl(this.caseStepByRequest.getBaseUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            this.request = retrofit.create(RequestMethods.class);
        } catch (Exception e) {
            this.errorMassage = "BaseURL错误！";
            System.out.println("=====异常======");
        }


    }

    public RetrofitToolsByRequest() {
    }

    public RetrofitToolsByRequest(CaseStepByRequest request) {
        this.errorMassage = "";
        this.MsgHeather = "";
        this.caseStepByRequest = request;
        System.out.println("RequestDTO:" + caseStepByRequest.toString());
        RetrofitBuilder();

    }

    /**
     * 执行发送测试请求的方法
     *
     * @return
     */

    public ResponseResult exceRequest() {
        ApplicationTools applicationTools= new ApplicationTools();
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMsg("");

        responseResult.setMsg(this.errorMassage);
        RequestInfo requestInfoDTO = new RequestInfo();
        ResponseInfo responseInfoDTO = new ResponseInfo();
        responseInfoDTO.setErrorbody("");
        responseInfoDTO.setMsg("");
        try {

            if (!responseResult.getMsg().isEmpty()) {
                return responseResult;
            }

            if (this.caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_POST)) {
                //System.out.println("Method: " + this.method);
                this.method = "POST";
                this.requestCall = this.request.POST(this.caseStepByRequest.getApi(), this.caseStepByRequest.getRe_parameters());

            } else if (this.caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_DELETE)) {
                this.method = "DELETE";
                if (caseStepByRequest.getRe_parameters().equals("")) {
                    this.requestCall = this.request.DELETE_NO_Parameters(this.caseStepByRequest.getApi());
                } else {
                    this.requestCall = this.request.DELETE(this.caseStepByRequest.getApi(), caseStepByRequest.getRe_parameters());
                }
            } else if (this.caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_PUT)) {

                this.method = "PUT";
                this.requestCall = this.request.PUT(this.caseStepByRequest.getApi(), this.caseStepByRequest.getRe_parameters());

            } else if (this.caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_GET)) {

                this.method = "GET";
                responseResult.setMsg(useRequestByGet());
            } else {
                System.out.println("Method: " + method);
            }
            //System.out.println("发送请求...");


            System.out.println("======" + !responseResult.getMsg().equals(""));
            if (!responseResult.getMsg().equals("")) {
                return responseResult;
            }
            this.re = this.requestCall.execute();


            //System.out.println(response);
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>\t\tREQUEST INFO\t\t>>>>>>>>>>>>>>>>>>>>>>>");
            //System.out.println("Request:\t" + response.request().toString());

            System.out.println("Method: " + this.method );
            System.out.println("URL:\t" + this.requestCall.request().toString().split(",")[1].substring(this.requestCall.request().toString().split(",")[1].indexOf("=") + 1));
            System.out.println("Request Headers:\t" + this.requestCall.request().headers());
            System.out.println("Request Body:\t" + this.caseStepByRequest.getRe_parameters());
            requestInfoDTO.setMethod(this.method);
            if (!this.method.equals("GET")) {
                requestInfoDTO.setUrl(this.requestCall.request().toString().split(",")[1].substring(this.requestCall.request().toString().split(",")[1].indexOf("=") + 1));
            }
            requestInfoDTO.setUrl(this.requestCall.request().toString().split(",")[1].substring(this.requestCall.request().toString().split(",")[1].indexOf("=") + 1));
            requestInfoDTO.setHeaders(applicationTools.mapReaderToHtmlText(this.requestCall.request().headers().toMultimap()));
            requestInfoDTO.setBody(this.caseStepByRequest.getRe_parameters());


            System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<\t\tRESPONSE INFO\t\t<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(re);
            System.out.println("Code:\t" + this.re.code());
            System.out.println("Headers:\n" + this.re.headers());


            System.out.println("Successful:\t" + this.re.isSuccessful());
            System.out.println("Message:\t" + this.re.message());

            if (!(caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_DELETE)) || !(caseStepByRequest.getRequest_method().equals(ConfigValue.RequestMethod_PUT))) {
                System.out.println("Body:\t" + this.re.body());
                responseInfoDTO.setBody(this.re.body());
            }
            responseInfoDTO.setCode(this.re.code());
            responseInfoDTO.setHeaders(applicationTools.mapReaderToHtmlText(this.re.headers().toMultimap()));
            if (this.re.code() != 200) {
                responseInfoDTO.setErrorbody(this.re.errorBody().string().toString());
                System.out.println("ErrorBody:\t" + this.re.errorBody().string().toString()+responseInfoDTO.getErrorbody());
            }

            responseInfoDTO.setSuccessful(this.re.isSuccessful());
            responseInfoDTO.setMessage(this.re.message());


            responseResult.setResponseInfo(responseInfoDTO);
            responseResult.setRequestInfo(requestInfoDTO);
            return responseResult;
        } catch (Exception e) {
            responseResult.setMsg("传参错误！" + e);
            e.printStackTrace();
            return responseResult;
        }
    }

    /**
     * 判断get请求参数传入格式是否正确
     * 传入格式为 map格式 ：A:123;b:234
     *
     * @return
     */

    public String useRequestByGet() {

        String msg = "";
        if (caseStepByRequest.getRe_parameters().isEmpty()) {
            Map maps = new HashMap<String, Object>();
            this.requestCall = this.request.GET_With_Parameters(this.caseStepByRequest.getApi(), maps);
            //System.out.println("GET请求参数:\n原值：" + caseStepByRequest.getRe_parameters() + "\nmap：" + maps);
        } else {
            try {

                if (caseStepByRequest.getRe_parameters().contains(";") == false && caseStepByRequest.getRe_parameters().contains(":") == false) {
                    msg = "GET请求参数错误！";
                } else {
                    String[] paramaters = caseStepByRequest.getRe_parameters().split(";");
                    Map maps = new HashMap<String, Object>();
                    for (int i = 0; i < paramaters.length; i++) {
                        //System.out.println("GET请求参数:\n原值：" + paramaters[i]);
                        //System.out.println(paramaters[i].contains(":"));
                        //System.out.println(paramaters[i].split(":")[0] + " " + paramaters[i].split(":")[1]);
                        maps.put(paramaters[i].split(":")[0], paramaters[i].split(":")[1]);

                    }

                    this.requestCall = this.request.GET_With_Parameters(this.caseStepByRequest.getApi(), maps);
                    System.out.println("GET请求参数" + maps);
                }




               /*
                Gson gson = new Gson();

                Map maps = (Map) JSON.parse(caseStepByRequest.getRe_parameters());

                System.out.println("转换MAP");
                System.out.println(this.caseStepByRequest.getApi());
                System.out.println("========  map : " + maps);
                if (maps == null) {

                    this.requestCall = this.request.GET(this.caseStepByRequest.getApi());
                    System.out.println("传值到call 1:" + requestCall);
                } else {
                    this.requestCall = this.request.GET_With_Parameters(this.caseStepByRequest.getApi(), maps);
                    System.out.println("传值到call 2:" + requestCall);
                }
                */
            } catch (Exception e) {
                msg = "GET请求参数错误！";
                e.printStackTrace();

            }
        }


        return msg;
    }


    public Map<String, Object> stringToMap(String s) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] str = s.split(";");
        if (str[str.length - 1].equals(";")) {
            str[s.length() - 1].replace(";", "");
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);

            //System.out.println(str[i].substring(0,str[i].indexOf("=")));
            //System.out.println(str[i].substring(str[i].indexOf("=")+1));
            map.put(str[i].substring(0, str[i].indexOf("=")), str[i].substring(str[i].indexOf("=") + 1));

        }
        return map;
    }


}
