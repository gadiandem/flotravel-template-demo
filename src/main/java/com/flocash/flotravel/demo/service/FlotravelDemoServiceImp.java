package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.flocash.RefundParameter;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCN;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationItem;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.exception.ApplicationException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.*;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.PACKAGE_HOTEL_ROOM_URL;

@Service
@Slf4j
public class FlotravelDemoServiceImp implements FlotravelDemoService {
    @Value("${env}")
    private String env;
    private String domainUrl;
    private WebClientService webclientService;

    @Autowired
    public void setWebclientService(WebClientService webclientService) {
        this.webclientService = webclientService;
    }

//    @Autowired
//    public void setProviderService(PackageProviderService providerService) {
//        this.providerService = providerService;
//    }
//
//    @Autowired
//    public void setSummaryPackageMapper(SummaryPackageMapper summaryPackageMapper) {
//        this.summaryPackageMapper = summaryPackageMapper;
//    }
//
//    @Autowired
//    public void setSummaryPackageCacheService(SummaryPackageCacheService summaryPackageCacheService) {
//        this.summaryPackageCacheService = summaryPackageCacheService;
//    }
//
//    @Autowired
//    public void setFlocashVCNService(FlocashVCNService flocashVCNService) {
//        this.flocashVCNService = flocashVCNService;
//    }
//
//    @Autowired
//    public void setFlocashCreditCardService(FlocashCreditCardService flocashCreditCardService) {
//        this.flocashCreditCardService = flocashCreditCardService;
//    }
//
//    @Autowired
//    public void setModelMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

    @PostConstruct
    public void selectDomainUrl() {
        if (LIVE_ENV.equalsIgnoreCase(env)) {
            domainUrl = FLOTRAVEL_LIVE_DOMAIN;
        } else {
            domainUrl = FLOTRAVEL_TEST_DOMAIN;
        }
    }

    @Override
    public DestinationRes destinationSearch(String keyword) {
        try {
            keyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            throw new ApplicationException(SERVER_ERROR, e.getMessage(), 500);
        }

        List<DestinationItem> res = webclientService.retRequestWithEndpoint(domainUrl + DESTINATION_URL + "?keywords=" + keyword)
                .get()
                .retrieve()
                .bodyToFlux(DestinationItem.class)
                .collectList().block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("DestinationRes: " + listResult);
        DestinationRes destinationRes = new DestinationRes();
        if (res != null && res.size() > 0) {
            destinationRes.setResult(res);
            destinationRes.setCode(SUCCESS_CODE);
            destinationRes.setMessage(GET_DESTINATION_SUCCESS);
        } else {
            destinationRes.setResult(Collections.EMPTY_LIST);
            destinationRes.setCode(NO_RESULT_CODE);
            destinationRes.setMessage(NO_RESULT_MASSAGE);
        }
        return destinationRes;
    }

    @Override
    public DestinationRes destinationElasticSearch(String keyword) {
        try {
            keyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            throw new ApplicationException(SERVER_ERROR, e.getMessage(), 500);
        }
        List<DestinationItem> res = webclientService.retRequestWithEndpoint(DESTINATION_ELASTICSEARCH_URL + "?keywords=" + keyword)
                .get()
                .retrieve()
                .bodyToFlux(DestinationItem.class)
                .collectList().block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("Destination Elastic Res: " + listResult);
        DestinationRes destinationRes = new DestinationRes();
        if (res != null && res.size() > 0) {
            destinationRes.setResult(res);
            destinationRes.setCode(SUCCESS_CODE);
            destinationRes.setMessage(GET_DESTINATION_SUCCESS);
        } else {
            destinationRes.setResult(Collections.EMPTY_LIST);
            destinationRes.setCode(NO_RESULT_CODE);
            destinationRes.setMessage(NO_RESULT_MASSAGE);
        }
        return destinationRes;
    }

    @Override
    public PackageShoppingRes shoppingPackage(PackageShoppingReq req) {
        List<PackageShoppingItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_SHOPPING_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToFlux(PackageShoppingItem.class)
                .collectList().block();
        Gson gson = new Gson();
        if(res == null){
            res = Collections.emptyList();
        }
        String listResult = gson.toJson(res.size());
        log.info("Shopping Package: " + listResult + " item");
        PackageShoppingRes packageShoppingRes = new PackageShoppingRes();
        if (res.size() > 0) {
            packageShoppingRes.setResult(res);
            packageShoppingRes.setCode(SUCCESS_CODE);
            packageShoppingRes.setMessage(SHOPPING_PACKAGE_SUCCESS);
        } else {
            packageShoppingRes.setResult(Collections.emptyList());
            packageShoppingRes.setResult(res);
            packageShoppingRes.setCode(NO_RESULT_CODE);
            packageShoppingRes.setMessage(NO_RESULT_MASSAGE);
        }
        return packageShoppingRes;
    }

    @Override
    public HotelRoomDetailRes getPackageHotelDetail(HotelRoomDetailReq req) {
        List<HotelRoomDetailItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_HOTEL_ROOM_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToFlux(HotelRoomDetailItem.class)
                .collectList().block();
        Gson gson = new Gson();
        if(res == null){
            res = Collections.emptyList();
        }
        String listResult = gson.toJson(res.size());
        log.info("Shopping Package: " + listResult + " item");
        HotelRoomDetailRes hotelRoomDetailRes = new HotelRoomDetailRes();
        if (res.size() > 0) {
            hotelRoomDetailRes.setResult(res);
            hotelRoomDetailRes.setCode(SUCCESS_CODE);
            hotelRoomDetailRes.setMessage(PACKAGE_DETAIL_SUCCESS);
        } else {
            hotelRoomDetailRes.setResult(Collections.emptyList());
            hotelRoomDetailRes.setResult(res);
            hotelRoomDetailRes.setCode(NO_RESULT_CODE);
            hotelRoomDetailRes.setMessage(NO_RESULT_MASSAGE);
        }
        return hotelRoomDetailRes;
    }

    @Override
    public OptionalRes getOptionalList(OptionalReq req) {
        OptionalList res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_OPTIONAL_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToMono(OptionalList.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("Optional res: " + listResult);
        OptionalRes optionalRes = new OptionalRes();
        if (res != null) {
            optionalRes.setResult(res);
            optionalRes.setCode(SUCCESS_CODE);
            optionalRes.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            optionalRes.setResult(null);
            optionalRes.setCode(NO_RESULT_CODE);
            optionalRes.setMessage(NO_RESULT_MASSAGE);
        }
        return optionalRes;
    }

    @Override
    public SummaryPackageRes getSummary(SummaryPackageReq req) {
        SummaryPackage res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_SUMMARY_URL)
                .post()
                .body(Mono.just(req), SummaryPackageReq.class)
                .retrieve()
                .bodyToMono(SummaryPackage.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("SummaryPackageRes res: " + listResult);
        SummaryPackageRes summaryPackageRes = new SummaryPackageRes();
        if (res != null) {
            summaryPackageRes.setResult(res);
            summaryPackageRes.setCode(SUCCESS_CODE);
            summaryPackageRes.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            summaryPackageRes.setResult(null);
            summaryPackageRes.setCode(NO_RESULT_CODE);
            summaryPackageRes.setMessage(NO_RESULT_MASSAGE);
        }
        return summaryPackageRes;
    }

    @Override
    public FlocashVCNRes requestVcn(VcnRequest req) {
        FlocashVCN res = webclientService.retRequestWithEndpoint(domainUrl + REQUEST_VCN_URL)
                .post()
                .body(Mono.just(req), VcnRequest.class)
                .retrieve()
                .bodyToMono(FlocashVCN.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("FlocashVCN res: " + listResult);
        FlocashVCNRes summaryPackageRes = new FlocashVCNRes();
        if (res != null) {
            summaryPackageRes.setResult(res);
            summaryPackageRes.setCode(SUCCESS_CODE);
            summaryPackageRes.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            summaryPackageRes.setResult(null);
            summaryPackageRes.setCode(NO_RESULT_CODE);
            summaryPackageRes.setMessage(NO_RESULT_MASSAGE);
        }
        return summaryPackageRes;
    }

    @Override
    public CreateOrderPackageRes createOrder(OrderPackageReq req) {
        OrderPackage res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_CREATE_URL)
                .post()
                .body(Mono.just(req), OrderPackageReq.class)
                .retrieve()
                .bodyToMono(OrderPackage.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("OrderPackage res: " + listResult);
        CreateOrderPackageRes createOrderPackageRes = new CreateOrderPackageRes();
        if (res != null) {
            createOrderPackageRes.setResult(res);
            createOrderPackageRes.setCode(SUCCESS_CODE);
            createOrderPackageRes.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            createOrderPackageRes.setResult(null);
            createOrderPackageRes.setCode(NO_RESULT_CODE);
            createOrderPackageRes.setMessage(NO_RESULT_MASSAGE);
        }
        return createOrderPackageRes;
    }

    @Override
    public CancelOrderPackageRes cancelBooking(RefundParameter req) {
        OrderPackage res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_CANCEL_URL)
                .post()
                .body(Mono.just(req), RefundParameter.class)
                .retrieve()
                .bodyToMono(OrderPackage.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("RefundParameter res: " + listResult);
        CancelOrderPackageRes cancelOrderPackageRes = new CancelOrderPackageRes();
        if (res != null) {
            cancelOrderPackageRes.setResult(res);
            cancelOrderPackageRes.setCode(SUCCESS_CODE);
            cancelOrderPackageRes.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            cancelOrderPackageRes.setResult(null);
            cancelOrderPackageRes.setCode(NO_RESULT_CODE);
            cancelOrderPackageRes.setMessage(NO_RESULT_MASSAGE);
        }
        return cancelOrderPackageRes;
    }

    @Override
    public HistoryOrderPackageListRes getBookingHistoryList(HistoryOrderPackageListReq req) {
        HistoryOrderPackageList res = webclientService.retRequestWithEndpoint(domainUrl + BOOKING_LIST_URL)
                .post()
                .body(Mono.just(req), HistoryOrderPackageListReq.class)
                .retrieve()
                .bodyToMono(HistoryOrderPackageList.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("HistoryOrderPackageListRes: " + listResult);
        HistoryOrderPackageListRes historyOrderPackageListRes = new HistoryOrderPackageListRes();
        if (res != null) {
            historyOrderPackageListRes.setResult(res);
            historyOrderPackageListRes.setCode(SUCCESS_CODE);
            historyOrderPackageListRes.setMessage(PACKAGE_DETAIL_SUCCESS);
        } else {
            historyOrderPackageListRes.setCode(NO_RESULT_CODE);
            historyOrderPackageListRes.setMessage(NO_RESULT_MASSAGE);
        }
        return historyOrderPackageListRes;
    }

    @Override
    public HistoryOrderPackageDetailRes getBookingHistoryDetail(HistoryOrderPackageDetailReq req) {
        HistoryOrderPackageDetail res = webclientService.retRequestWithEndpoint(domainUrl + BOOKING_DETAIL_URL)
                .post()
                .body(Mono.just(req), HistoryOrderPackageDetailReq.class)
                .retrieve()
                .bodyToMono(HistoryOrderPackageDetail.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("HistoryOrderPackageDetailRes: " + listResult);
        HistoryOrderPackageDetailRes historyOrderPackageListRes = new HistoryOrderPackageDetailRes();
        if (res != null) {
            historyOrderPackageListRes.setResult(res);
            historyOrderPackageListRes.setCode(SUCCESS_CODE);
            historyOrderPackageListRes.setMessage(PACKAGE_DETAIL_SUCCESS);
        } else {
            historyOrderPackageListRes.setCode(NO_RESULT_CODE);
            historyOrderPackageListRes.setMessage(NO_RESULT_MASSAGE);
        }
        return historyOrderPackageListRes;
    }

    @Override
    public void deleteBookingRecord(String packageBookingId) {

    }
}
