package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.user.SubscriptionReqDTO;
import com.example.demo.spotifyClone.dto.user.SubscriptionRespDTO;
import com.example.demo.spotifyClone.entity.Subscription;
import com.example.demo.spotifyClone.services.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
    @ResponseBody
    @PostMapping(path = "subscription/add")
    public ResponseEntity<SubscriptionRespDTO> addSubscription(@RequestBody SubscriptionReqDTO subscriptionReqDTO){
        SubscriptionRespDTO addSubscription = this.subscriptionService.addSubscription(subscriptionReqDTO);
        return new ResponseEntity<>(addSubscription, HttpStatus.CREATED);
    }
    @GetMapping(path = "subscription/get-all-subscription")
    public ResponseEntity<List<Subscription>> getAllSubscription(){
     return ResponseEntity.ok(this.subscriptionService.getAllSubscription());
    }
    @GetMapping(path = "subscription/get-subscription-by-id/{subscriptionId}")
    public ResponseEntity<SubscriptionRespDTO> getSubscriptionById(@PathVariable Integer subscriptionId){
        return ResponseEntity.ok(this.subscriptionService.getSubscriptionById(subscriptionId));
    }
    @PutMapping(path = "subscription/update-subscription-by-id/{subscriptionId}")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription,@PathVariable Integer subscriptionId){
        return ResponseEntity.ok(this.subscriptionService.updateSubscription(subscription, subscriptionId));
    }
    @DeleteMapping(path = "subscription/delete-subscription/{subscriptionId}")
    public ResponseEntity<String> deleteSubscription(@PathVariable Integer subscriptionId){
        this.subscriptionService.deleteSubscription(subscriptionId);
        return ResponseEntity.ok("subscription deleted successfully!!");
    }
}
