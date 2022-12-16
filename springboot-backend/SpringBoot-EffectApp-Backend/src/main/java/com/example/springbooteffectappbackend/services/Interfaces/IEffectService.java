package com.example.springbooteffectappbackend.services.Interfaces;

import com.example.springbooteffectappbackend.model.SignalEffect;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IEffectService {
    public List<SignalEffect> getAllEffects();

    public Optional<SignalEffect> getEffectById(Long id);

    public SignalEffect createEffect(SignalEffect effect);

    public boolean  deleteEffect( Long id);
    public List<SignalEffect> getEffectsByUser(String id);
}
