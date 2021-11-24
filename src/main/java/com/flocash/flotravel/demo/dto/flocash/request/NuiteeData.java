package com.flocash.flotravel.demo.dto.flocash.request;

import com.flocash.flotravel.dto.hotel.shopping.AwsImage;

import java.io.Serializable;

public class NuiteeData implements Serializable {
    private String sessionId;
    private String roomCode;
    private String propertyCode;
    private long hotelId;
    private String userId;

    //aws image
    private AwsImage image;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AwsImage getImage() {
        return image;
    }

    public void setImage(AwsImage image) {
        this.image = image;
    }
}
