package com.example.springbooteffectappbackend.Services;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import com.example.springbooteffectappbackend.services.EffectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EffectServiceTests {
    @Autowired
    private  EffectRepository effectRepository;

    @Autowired
    private EffectService effectService;

    @Test
    void createEffect(){
        SignalEffect effect = new SignalEffect("effect1","<script>console.log(hellowWorld)</script>","1234","testUser");
        SignalEffect returnEffect = effectService.createEffect(effect);

        assert(returnEffect).equals(effect);
    }
}
