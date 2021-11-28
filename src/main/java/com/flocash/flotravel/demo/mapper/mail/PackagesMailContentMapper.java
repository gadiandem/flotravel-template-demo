package com.flocash.flotravel.demo.mapper.mail;

import com.flocash.flotravel.demo.dto.mail.MailPackagesContent;
import com.flocash.flotravel.demo.dto.packages.provider.PackageOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class PackagesMailContentMapper {

//    private PackageInfoService packageInfoService;
//    private HotelPackageService hotelPackageService;
//    private RoomHotelService roomHotelService;
//    private SupplementService supplementService;
//    private TaxPackageService taxPackageService;
//    private TourPackageService tourPackageService;
//    private TransferService transferService;

//    @Autowired
//    public void setPackageInfoService(PackageInfoService packageInfoService) {
//        this.packageInfoService = packageInfoService;
//    }
//
//    @Autowired
//    public void setHotelPackageService(HotelPackageService hotelPackageService) {
//        this.hotelPackageService = hotelPackageService;
//    }
//
//    @Autowired
//    public void setRoomHotelService(RoomHotelService roomHotelService) {
//        this.roomHotelService = roomHotelService;
//    }
//
//    @Autowired
//    public void setSupplementService(SupplementService supplementService) {
//        this.supplementService = supplementService;
//    }
//
//    @Autowired
//    public void setTaxPackageService(TaxPackageService taxPackageService) {
//        this.taxPackageService = taxPackageService;
//    }
//
//    @Autowired
//    public void setTourPackageService(TourPackageService tourPackageService) {
//        this.tourPackageService = tourPackageService;
//    }

//    @Autowired
//    public void setTransferService(TransferService transferService) {
//        this.transferService = transferService;
//    }

    public MailPackagesContent mapMailPackagesContent(PackageOrder model, String reqUrl) {
        MailPackagesContent data = new MailPackagesContent();
        data.setAmount(model.getAmount());
        LocalDate date = Instant.ofEpochMilli((long) model.getOrderDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        data.setOrderDate(date);
        data.setDateBooking(date);
        data.setCurrency(model.getCurrency());
        data.setCurrencyName(model.getCurrencyName());
        data.setItem_name(model.getItem_name());
        data.setQuantity(model.getQuantity());
        data.setItem_price(model.getItem_price());
        data.setOrderId(model.getOrderId());
        data.setTracking(model.getTracking());
        data.setTraceNumber(model.getTraceNumber());
        data.setPaymentChannel(model.getPaymentChannel());
        data.setPayer(model.getPayer());
        data.setBookingStatus(model.getBookingStatus());
        data.setReason(model.getReason());

        LocalDate startDate =  LocalDate.parse(model.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        data.setStartDate(startDate);
        data.setCancelDateReq(model.getCancelDateReq());
        data.setBookingStatusDes(model.getBookingStatusDes());
        data.setCancelDateConfirm(model.getCancelDateConfirm());

        String refLink = reqUrl + "/#/packages/history/" + model.getId();
        data.setRefLink(refLink);

//        if (model.getPackageId() != null) {
//            data.setPackageInfo(packageInfoService.getPackageInfo(model.getPackageId()));
//        }
//        if (model.getPackageTax() != null) {
//            data.setTax(model.getPackageTax());
//        }
//        if (model.getHotelId() != null) {
//            data.setHotelPackage(hotelPackageService.getHotelPackage(model.getHotelId()));
//        }
//        if (model.getRooms() != null && model.getRooms().size() > 0) {
//            List<HotelRoom> roomList = new ArrayList<>();
//            for (int i = 0; i < model.getRooms().size(); i++) {
//                HotelRoom room = roomHotelService.getHotelRoom(model.getRooms().get(i).getId());
//                roomList.add(room);
//            }
//            data.setHotelRooms(roomList);
//        }
//        if (model.getSupplements() != null && model.getSupplements().size() > 0) {
//            List<Supplement> supplements = new ArrayList<>();
//            for (ItemPrice itemPrice : model.getSupplements()) {
//                Supplement supplement = supplementService.getSupplementNoException(itemPrice.getId());
//                if (supplement != null) {
//                    supplements.add(supplement);
//                }
//            }
//            data.setSupplements(supplements);
//        }

//        if (model.getTours() != null && model.getTours().size() > 0) {
//            List<TourInPackage> tourInPackages = new ArrayList<>();
//            for (ItemPrice itemPrice : model.getTours()) {
//                TourInPackage tourInPackage = tourPackageService.getTourPackageNoException(itemPrice.getId());
//                if (tourInPackage != null) {
//                    tourInPackages.add(tourInPackage);
//                }
//            }
//            data.setTourInPackages(tourInPackages);
//        }
//        if (model.getTransfers() != null && model.getTransfers().size() > 0) {
//            List<TransferInPackage> transferInPackages = new ArrayList<>();
//            for (ItemPrice itemPrice : model.getTransfers()) {
//                TransferInPackage transfer = transferService.getTransferNoException(itemPrice.getId());
//                if (transfer != null) {
//                    transferInPackages.add(transfer);
//                }
//            }
//            data.setTransferInPackages(transferInPackages);
//        }
        return data;
    }

}
