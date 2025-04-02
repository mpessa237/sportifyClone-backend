package com.example.demo.spotifyClone.dto.user;

import lombok.Data;

import java.util.Date;

@Data
public class SubscriptionReqDTO {
    private Date startDate;
    private Date endDate;
    private String typeSubscription;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(String typeSubscription) {
        this.typeSubscription = typeSubscription;
    }
}
