package com.example.springbooteffectappbackend.services;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import com.example.springbooteffectappbackend.services.Interfaces.IEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EffectService implements IEffectService {
    @Autowired
    private EffectRepository effectRepository;

    public List<SignalEffect> getAllEffects(){
        return effectRepository.findAll();
    }

    public Optional<SignalEffect> getEffectById(Long id){
        return effectRepository.findById(id);
    }

    public SignalEffect createEffect(SignalEffect effect){
        return effectRepository.save(effect);
    }

    public boolean deleteEffect(Long id){
        try{
            effectRepository.deleteById(id);
            return  true;
        }catch (Error e){
            return false;
        }

    }
    public List<SignalEffect> getEffectsByUser(String id) {
        return effectRepository.findBySubjectId(id);
    }
}
