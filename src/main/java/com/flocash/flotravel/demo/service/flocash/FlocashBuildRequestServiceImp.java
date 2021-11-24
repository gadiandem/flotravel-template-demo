package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.common.AuthBasic;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpRes;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpResponse;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.FlocashVCNReq;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCN;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.service.WebClientService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static com.flocash.flotravel.demo.constant.Constant.*;

@Service
@Slf4j
public class FlocashBuildRequestServiceImp implements FlocashBuildRequestService {

//    @Value("${FLOCASH_USER}")
//    public String FLOCASH_USER;
//    @Value("${FLOCASH_PASS}")
//    public String FLOCASH_PASS;

    private WebClientService webClientService;

    @Autowired
    public void setWebClientService(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    //    @Override
//    public CloseableHttpResponse postFormUrlencoded(String endpoint, String auth, String data) {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(endpoint);
//        int statusCode = 500;
//        CloseableHttpResponse response;
//        try {
//            StringEntity postingString = new StringEntity(data);
//            String BasicBase64format = Base64.getEncoder().encodeToString(auth.getBytes());
//            post.setEntity(postingString);
//            post.setHeader("Content-type", "application/x-www-form-urlencoded");
//            post.setHeader("Authorization", "Basic " + BasicBase64format);
//            response = httpClient.execute(post);
//            statusCode = response.getStatusLine().getStatusCode();
//            log.info("PostFormUrlEncoded: " + statusCode);
//        } catch (IOException e) {
//            throw new ApplicationException(APP_ERROR_CODE, e.getMessage(), statusCode);
//        }
//        return response;
//    }

    @Override
    public OtpResponse updateOpt(String endpoint, AuthBasic auth, String data) {
        OtpRes res = webClientService.requestAuthBasic(endpoint, auth)
                .post()
                .body(BodyInserters.fromFormData("otp", data))
                .retrieve()
                .bodyToMono(OtpRes.class)
                .block();
        OtpResponse response = new OtpResponse();
        if (res != null) {
            response.setResult(res);
            response.setCode(SUCCESS_CODE);
            response.setMessage(PACKAGE_DETAIL_SUCCESS);
        } else {
            response.setResult(null);
            response.setCode(NO_RESULT_CODE);
            response.setMessage(NO_RESULT_MASSAGE);
        }
        return null;
    }

    @Override
    public FlocashVCNRes vcnRequest(String endpoint, AuthBasic auth, FlocashVCNReq req) {

        FlocashVCN res = webClientService.requestAuthBasic(endpoint, auth)
                .post()
                .body(Mono.just(req), FlocashVCNReq.class)
                .retrieve()
                .bodyToMono(FlocashVCN.class)
                .block();
        Gson gson = new Gson();
        String resData = gson.toJson(res);
        log.info("RequestVCN res " + resData);
        FlocashVCNRes vcnRes = new FlocashVCNRes();
        if (res != null) {
            vcnRes.setResult(res);
            vcnRes.setCode(SUCCESS_CODE);
            vcnRes.setMessage(PACKAGE_DETAIL_SUCCESS);
        } else {
            vcnRes.setResult(null);
            vcnRes.setCode(NO_RESULT_CODE);
            vcnRes.setMessage(NO_RESULT_MASSAGE);
        }
        return vcnRes;
    }

//    @Override
//    public CloseableHttpResponse getRequest(String endpoint, String auth) {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet get = new HttpGet(endpoint);
//        int statusCode = 500;
//        CloseableHttpResponse response;
//        try {
//            String BasicBase64format = Base64.getEncoder().encodeToString(auth.getBytes());
//            get.setHeader("Content-type", "application/json");
//            get.setHeader("Authorization", "Basic " + BasicBase64format);
//            response = httpClient.execute(get);
//            statusCode = response.getStatusLine().getStatusCode();
//        } catch (IOException e) {
//            throw new ApplicationException(APP_ERROR_CODE, e.getMessage(), statusCode);
//        }
//        return response;
//    }


}
