package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.user.SubscriptionReqDTO;
import com.example.demo.spotifyClone.dto.user.SubscriptionRespDTO;
import com.example.demo.spotifyClone.entity.Subscription;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    public Subscription toEntity(SubscriptionReqDTO subscriptionReqDTO){
        Subscription subscription = new Subscription();
        subscription.setStartDate(subscriptionReqDTO.getStartDate());
        subscription.setEndDate(subscriptionReqDTO.getEndDate());
        subscription.setTypeSubscription(subscriptionReqDTO.getTypeSubscription());
        return subscription;
    }

    public SubscriptionRespDTO toDto(Subscription subscription){
        SubscriptionRespDTO subscriptionRespDTO = new SubscriptionRespDTO();
        subscriptionRespDTO.setSubscriptionId(subscription.getSubscriptionId());
        subscriptionRespDTO.setStartDate(subscription.getStartDate());
        subscriptionRespDTO.setEndDate(subscription.getEndDate());
        subscriptionRespDTO.setTypeSubscription(subscription.getTypeSubscription());

        return subscriptionRespDTO;

    }
}
