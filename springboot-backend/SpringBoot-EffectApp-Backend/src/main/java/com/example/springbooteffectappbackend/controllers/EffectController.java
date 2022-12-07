package com.example.springbooteffectappbackend.controllers;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.model.SignalEffectDTO;
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
    public SignalEffect createEffect(@RequestBody @Valid SignalEffectDTO effect){
        SignalEffect persistentEffect = new SignalEffect();
        persistentEffect.setEffectName(effect.effectName);
        persistentEffect.setEffectContent(effect.effectContent);
        persistentEffect.setCreatorName(effect.creatorName);
        persistentEffect.setSubjectId(effect.subjectId);
        return effectRepository.save(persistentEffect);
    }

    @DeleteMapping
    public void  deleteEffect(@PathVariable Long id){
         effectRepository.deleteById(id);
    }
}


