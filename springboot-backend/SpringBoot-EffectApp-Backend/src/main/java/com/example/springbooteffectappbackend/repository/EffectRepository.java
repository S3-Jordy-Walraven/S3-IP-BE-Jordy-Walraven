package com.example.springbooteffectappbackend.repository;

import com.example.springbooteffectappbackend.model.SignalEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends JpaRepository<SignalEffect,Long> {
}
