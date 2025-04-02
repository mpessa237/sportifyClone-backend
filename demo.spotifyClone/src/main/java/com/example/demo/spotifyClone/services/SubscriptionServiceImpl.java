package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.user.SubscriptionReqDTO;
import com.example.demo.spotifyClone.dto.user.SubscriptionRespDTO;
import com.example.demo.spotifyClone.entity.Subscription;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.SubscriptionMapper;
import com.example.demo.spotifyClone.repository.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepo subscriptionRepo;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionServiceImpl(SubscriptionRepo subscriptionRepo, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepo = subscriptionRepo;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Override
    public SubscriptionRespDTO addSubscription(SubscriptionReqDTO subscriptionReqDTO) {
        Subscription subscription = this.subscriptionMapper.toEntity(subscriptionReqDTO);
        Subscription addSubscription = this.subscriptionRepo.save(subscription);
        return this.subscriptionMapper.toDto(addSubscription);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return this.subscriptionRepo.findAll();
    }

    @Override
    public SubscriptionRespDTO getSubscriptionById(Integer subscriptionId) {
        Subscription subscription = this.subscriptionRepo.findById(subscriptionId)
                .orElseThrow(()-> new ResourceNotFoundException("subscription not found!!"));
        return this.subscriptionMapper.toDto(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription, Integer subscriptionId) {
        Optional<Subscription> subscriptionOptional = this.subscriptionRepo.findById(subscriptionId);

        if (subscriptionOptional.isEmpty())
            throw  new ResourceNotFoundException("subscription not found!!");

        if (subscription.getEndDate()!=null)
            subscriptionOptional.get().setEndDate(subscription.getEndDate());
        if (subscription.getStartDate()!=null)
            subscriptionOptional.get().setStartDate(subscription.getStartDate());

        return this.subscriptionRepo.saveAndFlush(subscriptionOptional.get());
    }


    @Override
    public void deleteSubscription(Integer subscriptionId) {
        this.subscriptionRepo.delete(this.subscriptionRepo.findById(subscriptionId)
                .orElseThrow(()-> new ResourceNotFoundException("subscription not found!!")));
    }
}
