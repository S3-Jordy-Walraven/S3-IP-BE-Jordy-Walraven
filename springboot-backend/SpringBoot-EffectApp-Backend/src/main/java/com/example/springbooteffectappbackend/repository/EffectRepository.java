package com.example.springbooteffectappbackend.repository;

import com.example.springbooteffectappbackend.model.SignalEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EffectRepository extends JpaRepository<SignalEffect,Long> {
    List<SignalEffect> findBySubjectId(String id);
}
