package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.common.AuthBasic;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpRes;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpResponse;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.FlocashVCNReq;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCN;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
//import org.apache.http.client.methods.CloseableHttpResponse;

public interface FlocashBuildRequestService {
//    CloseableHttpResponse postFormUrlencoded(String endpoint, String auth,String data);

    OtpResponse updateOpt(String endpoint, AuthBasic auth, String data);
    FlocashVCNRes vcnRequest(String endpoint, AuthBasic auth, FlocashVCNReq data);
//    CloseableHttpResponse getRequest(String endpoint, String auth);
}
