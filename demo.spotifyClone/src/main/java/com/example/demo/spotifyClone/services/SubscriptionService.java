package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.user.SubscriptionReqDTO;
import com.example.demo.spotifyClone.dto.user.SubscriptionRespDTO;
import com.example.demo.spotifyClone.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    SubscriptionRespDTO addSubscription(SubscriptionReqDTO subscriptionReqDTO);
    List<Subscription> getAllSubscription();
    SubscriptionRespDTO getSubscriptionById(Integer subscriptionId);
    Subscription updateSubscription(Subscription subscription,Integer subscriptionId);
    void deleteSubscription(Integer subscriptionId);
}
