package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.RefundParameter;
import com.flocash.flotravel.demo.dto.flocash.request.FlocashRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpRes;
import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.packages.provider.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationItem;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.exception.ApplicationException;
import com.flocash.flotravel.demo.mapper.packages.SummaryPackageMapper;
import com.flocash.flotravel.demo.service.provider.PackageProviderService;
import com.flocash.flotravel.demo.service.provider.SummaryPackageCacheService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.*;

@Service
@Slf4j
public class FlotravelDemoServiceImp implements FlotravelDemoService {
    @Value("${env}")
    private String env;
    private String domainUrl;
    private WebClientService webclientService;
    private PackageProviderService providerService;
    private SummaryPackageMapper summaryPackageMapper;
    private SummaryPackageCacheService summaryPackageCacheService;

    @Autowired
    public void setWebclientService(WebClientService webclientService) {
        this.webclientService = webclientService;
    }

    @Autowired
    public void setProviderService(PackageProviderService providerService) {
        this.providerService = providerService;
    }
    @Autowired
    public void setSummaryPackageMapper(SummaryPackageMapper summaryPackageMapper) {
        this.summaryPackageMapper = summaryPackageMapper;
    }
    @Autowired
    public void setSummaryPackageCacheService(SummaryPackageCacheService summaryPackageCacheService) {
        this.summaryPackageCacheService = summaryPackageCacheService;
    }

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
        SummaryPackageRes summaryPackageRes = new SummaryPackageRes();
        BigDecimal totalPrice = new BigDecimal(0);
        BigDecimal basePrice = new BigDecimal(0);
        PackageInfo packageInfo = providerService.getPackageInfo(req.getPackageInfo().getId());

        // package price
        if (req.getPackageInfo() != null && packageInfo != null) {
            basePrice = basePrice.add(packageInfo.getPrice());
            basePrice = basePrice.multiply(new BigDecimal(req.getPackageInfo().getCount()));
        }

        // supplement price
        if (req.getSupplements() != null && req.getSupplements().size() > 0) {
            BigDecimal supplementPrice = new BigDecimal(0);
            List<ItemPrice> supplements = req.getSupplements();
            for (ItemPrice itemPrice : supplements) {
                Supplement supplement = providerService.getSupplement(itemPrice.getId());
                if (supplement != null) {
//                    supplementPrice = supplementPrice.add((new BigDecimal(supplement.getPrice().trim())).multiply(new BigDecimal(itemPrice.getCount())));
                    supplementPrice = supplementPrice.add(supplement.getPrice()).multiply(new BigDecimal(itemPrice.getCount()));
                }
            }
            basePrice = basePrice.add(supplementPrice);
        }
        // tour price
        if (req.getTours() != null && req.getTours().size() > 0) {
            BigDecimal tourPackagePrice = new BigDecimal(0);
            List<ItemPrice> tours = req.getTours();
            for (ItemPrice itemPrice : tours) {
                TourInPackage tourPackage = providerService.getTourPackage(itemPrice.getId());
                if (tourPackage != null) {
                    tourPackagePrice = tourPackagePrice.add((tourPackage.getPrice().multiply(new BigDecimal(itemPrice.getCount()))));
                }
            }
            basePrice = basePrice.add(tourPackagePrice);
        }
        // transfer price
        if (req.getTransfers() != null && req.getTransfers().size() > 0) {
            BigDecimal transferPackagePrice = new BigDecimal(0);
            List<ItemPrice> transfers = req.getTransfers();
            for (ItemPrice itemPrice : transfers) {
                TransferInPackage transfer = providerService.getTransfer(itemPrice.getId());
                if (transfer != null) {
                    transferPackagePrice = transferPackagePrice.add(transfer.getAmount().multiply(new BigDecimal(itemPrice.getCount())));
                }
            }
            basePrice = basePrice.add(transferPackagePrice);
        }
        // base price
        summaryPackageRes.setBasePrice(basePrice);

        totalPrice = totalPrice.add(basePrice);
        summaryPackageRes.setTotalPrice(totalPrice);
        summaryPackageRes.setAvailable(true);
        summaryPackageRes.setStartDate(req.getStartDate());
//        summaryPackageRes.setItemCount(req.getItemCount());
        SummaryPackageCache summaryToSave = summaryPackageMapper.mapToSummaryPackageDomain(summaryPackageRes);
        summaryToSave.setPackageInfo(req.getPackageInfo());
        summaryToSave.setHotelId(req.getHotelId());
        summaryToSave.setHotelRooms(req.getHotelRooms());
        summaryToSave.setSupplements(req.getSupplements());
        summaryToSave.setTours(req.getTours());
        summaryToSave.setTransfers(req.getTransfers());
        SummaryPackageCache summarySaved = summaryPackageCacheService.addSummaryPackage(summaryToSave);
        summaryPackageRes.setId(summarySaved.getId());
        return summaryPackageRes;
    }

    @Override
    public OrderPackageRes createOrder(OrderPackageReq req, String environment) {
        PackageOrder p;
        FlocashRequest flocashRequest;
        SummaryPackageCache summaryPackageCache = summaryPackageCacheService.getSummaryPackage(req.getPackagesBookingInfo().getSummaryId());
        boolean availableBooking = summaryPackageCache.isAvailable();
        if (!availableBooking) {
            throw new ApplicationException(NO_RESULT_CODE, PACKAGE_NOT_AVAILABLE_MASSAGE, 400);
        }
        BigDecimal totalPrice = summaryPackageCache.getTotalPrice();
        req.getPaymentInfo().setPrice(totalPrice);
        String merchantAccount;
        if (LIVE_ENV.equalsIgnoreCase(env)) {
            merchantAccount = PROVIDER_WALLET_PROD;
        } else {
            merchantAccount = PROVIDER_WALLET_SANDBOX;
        }
//        if (req.getPaymentInfo() != null && req.getPaymentInfo().isVcnPayment()) {
//            if (req.getPaymentInfo().getTraceNumber() == null || req.getPaymentInfo().getTraceNumber().isEmpty()) {
//                throw new ApplicationException(APP_ERROR_CODE, missingTraceNumber, 400);
//            }
//            OtpRes vcnCard = flocashVCNService.updateOtpProvider(req.getPaymentInfo().getTraceNumber(), req.getPaymentInfo().getOtpValue(), env);
//            PaymentInfo paymentInfo;
//            // update agent email to payer
//            User userBooking = authService.getUser(req.getAccountBooking());
//            if (userBooking != null) {
//                String payerEmail = userBooking.getEmail();
//                paymentInfo = flocashVCNService.buildFlocashPaymentRequest(vcnCard.getCardOrder(), payerEmail);
//            } else {
//                paymentInfo = flocashVCNService.buildFlocashPaymentRequest(vcnCard.getCardOrder(), req.getBookingContact().getEmail());
//            }
//            flocashRequest = flocashCreditCardService.buildFlocashPaymentRequest(paymentInfo, merchantAccount);
//        } else {
//            flocashRequest = flocashCreditCardService.buildFlocashPaymentRequest(req.getPaymentInfo(), merchantAccount);
//        }
//        PackageOrder flocashPaymentRes = flocashCreditCardService.paymentPackagesBooking(flocashRequest);
//        if (flocashPaymentRes == null) {
//            throw new ApplicationException(APP_ERROR_CODE, FLOCASH_PAYMENT_FAIL, 500);
//        }
//        // set price and tax of package
//        flocashPaymentRes.setTotalPrice(totalPrice);
//        flocashPaymentRes.setPackageTax(summaryPackageCache.getPackageTax());
//        flocashPaymentRes.setStartDate(summaryPackageCache.getStartDate());
//        flocashPaymentRes.setCreateDate(LocalDateTime.now());
//        extraInfo(flocashPaymentRes, req);
//        addBookingRequestData(flocashPaymentRes, req, summaryPackageCache);
//
//        p = packageOrderService.addPackageOrder(flocashPaymentRes);
//        if (p != null) {
//            try {
//                awsMailService.sendEmailPackagesBooking(req.getBookingContact().getEmail(), p);
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//        }
//        OrderPackageRes bookingRes = orderPackageResMapper.mapOrderPackageRes(p);

//        return bookingRes;
        return null;
    }

    @Override
    public OrderPackageRes cancelBooking(RefundParameter req) {
//        List<HotelRoomDetailItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_HOTEL_ROOM_URL)
//                .post()
//                .body(Mono.just(req), PackageShoppingReq.class)
//                .retrieve()
//                .bodyToFlux(HotelRoomDetailItem.class)
//                .collectList().block();
//        Gson gson = new Gson();
//        String listResult = gson.toJson(res.size());
//        log.info("Shopping Package: " + listResult + " item");
//        HotelRoomDetailRes hotelRoomDetailRes = new HotelRoomDetailRes();
//        if (res.size() > 0) {
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(SUCCESS_CODE);
//            hotelRoomDetailRes.setMessage(PACKAGE_DETAIL_SUCCESS);
//        } else {
//            hotelRoomDetailRes.setResult(Collections.emptyList());
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(NO_RESULT_CODE);
//            hotelRoomDetailRes.setMessage(NO_RESULT_MASSAGE);
//        }
//        return hotelRoomDetailRes;
        return null;
    }

    @Override
    public Map<String, List<HistoryOrderPackageListRes>> getBookingList(HistoryOrderPackageListReq req) {
//        List<HotelRoomDetailItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_HOTEL_ROOM_URL)
//                .post()
//                .body(Mono.just(req), PackageShoppingReq.class)
//                .retrieve()
//                .bodyToFlux(HotelRoomDetailItem.class)
//                .collectList().block();
//        Gson gson = new Gson();
//        String listResult = gson.toJson(res.size());
//        log.info("Shopping Package: " + listResult + " item");
//        HotelRoomDetailRes hotelRoomDetailRes = new HotelRoomDetailRes();
//        if (res.size() > 0) {
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(SUCCESS_CODE);
//            hotelRoomDetailRes.setMessage(PACKAGE_DETAIL_SUCCESS);
//        } else {
//            hotelRoomDetailRes.setResult(Collections.emptyList());
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(NO_RESULT_CODE);
//            hotelRoomDetailRes.setMessage(NO_RESULT_MASSAGE);
//        }
//        return hotelRoomDetailRes;
        return null;
    }

    @Override
    public HistoryOrderPackageDetailRes getBookingDetail(HistoryOrderPackageDetailReq req) {
//        List<HotelRoomDetailItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_HOTEL_ROOM_URL)
//                .post()
//                .body(Mono.just(req), PackageShoppingReq.class)
//                .retrieve()
//                .bodyToFlux(HotelRoomDetailItem.class)
//                .collectList().block();
//        Gson gson = new Gson();
//        String listResult = gson.toJson(res.size());
//        log.info("Shopping Package: " + listResult + " item");
//        HotelRoomDetailRes hotelRoomDetailRes = new HotelRoomDetailRes();
//        if (res.size() > 0) {
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(SUCCESS_CODE);
//            hotelRoomDetailRes.setMessage(PACKAGE_DETAIL_SUCCESS);
//        } else {
//            hotelRoomDetailRes.setResult(Collections.emptyList());
//            hotelRoomDetailRes.setResult(res);
//            hotelRoomDetailRes.setCode(NO_RESULT_CODE);
//            hotelRoomDetailRes.setMessage(NO_RESULT_MASSAGE);
//        }
//        return hotelRoomDetailRes;
        return null;
    }

    @Override
    public void deleteBookingRecord(String packageBookingId) {

    }

}
