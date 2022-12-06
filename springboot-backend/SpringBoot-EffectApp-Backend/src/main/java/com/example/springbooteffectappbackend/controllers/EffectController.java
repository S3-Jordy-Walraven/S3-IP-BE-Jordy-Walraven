package com.example.springbooteffectappbackend.controllers;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/effects")
public class EffectController {

    private final EffectRepository effectRepository;

    public EffectController(EffectRepository effectRepository) {
        this.effectRepository = effectRepository;
    }

    @GetMapping
    public List<SignalEffect> getAllEffects(){
        return effectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SignalEffect> getEffectById(@PathVariable Long id){
        return effectRepository.findById(id);
    }

    @PostMapping
    public SignalEffect createEffect(@RequestBody @Valid SignalEffect effect){
        return effectRepository.save(effect);
    }

    @DeleteMapping
    public void  deleteEffect(@PathVariable Long id){
         effectRepository.deleteById(id);
    }
}


