package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,Integer> {
}
