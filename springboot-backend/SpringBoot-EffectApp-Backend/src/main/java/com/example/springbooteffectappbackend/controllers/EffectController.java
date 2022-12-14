package com.example.springbooteffectappbackend.controllers;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.model.SignalEffectDTO;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import com.example.springbooteffectappbackend.services.Interfaces.IEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Signal;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/effects")
public class EffectController {

    @Autowired
    private IEffectService effectService;
    @GetMapping
    public ResponseEntity<?> getEffects(){
        List<SignalEffect> effects = effectService.getAllEffects();
        return ResponseEntity.ok().body(effects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEffectById(@PathVariable Long id){
        Optional<SignalEffect> effect = effectService.getEffectById(id);
        return ResponseEntity.ok().body(effect);
    }

    @PostMapping
    public ResponseEntity<?> createEffect(@RequestBody @Valid SignalEffectDTO effect){
        SignalEffect PostEffect = new SignalEffect();
        PostEffect.setEffectName(effect.getEffectName());
        PostEffect.setEffectContent(effect.getEffectContent());
        PostEffect.setSubjectId(effect.getSubjectId());
        PostEffect.setCreatorName(effect.getCreatorName());
        SignalEffect newEffect = effectService.createEffect(PostEffect);
        return ResponseEntity.ok().body(newEffect);
    }

    @DeleteMapping
    public ResponseEntity<?>  deleteEffect(@PathVariable Long id){

        boolean success = effectService.deleteEffect(id);
        return ResponseEntity.ok().body(success);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getEffectsByUser(@PathVariable String id){
        List<SignalEffect> effects = effectService.getEffectsByUser(id);
        return ResponseEntity.ok().body(effects);
    }
}


