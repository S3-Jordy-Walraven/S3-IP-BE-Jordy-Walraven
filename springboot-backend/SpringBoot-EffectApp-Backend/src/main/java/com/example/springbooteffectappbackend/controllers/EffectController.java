package com.example.springbooteffectappbackend.controllers;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/effects")
public class EffectController {

    @Autowired
    private EffectRepository effectRepository;

    @GetMapping
    public List<SignalEffect> getAllEffects(){
        return effectRepository.findAll();
    }

    @PostMapping
    public SignalEffect createEffect(@RequestBody @Valid SignalEffect effect){
        return effectRepository.save(effect);
    }
}


