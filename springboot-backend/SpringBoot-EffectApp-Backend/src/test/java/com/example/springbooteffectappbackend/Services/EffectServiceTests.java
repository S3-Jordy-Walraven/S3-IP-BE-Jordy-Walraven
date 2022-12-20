package com.example.springbooteffectappbackend.Services;

import com.example.springbooteffectappbackend.model.SignalEffect;
import com.example.springbooteffectappbackend.repository.EffectRepository;
import com.example.springbooteffectappbackend.services.EffectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

    @Test
    void getAllEffects(){
        SignalEffect effect = new SignalEffect("effect1","<script>console.log(hellowWorld)</script>","1234","testUser");
        SignalEffect effect2 = new SignalEffect("effect2","<script>console.log(hellowWorld)</script>","1234","testUser");
        effectService.createEffect(effect);
        effectService.createEffect(effect2);
        List<SignalEffect> allEffects = effectService.getAllEffects();

        Assertions.assertEquals(allEffects.size(),2);
    }

    @Test
    void getEffectById(){
        SignalEffect effect = new SignalEffect("effect1","<script>console.log(hellowWorld)</script>","1234","testUser");
        effectService.createEffect(effect);

        Optional<SignalEffect> validSignalEffect = effectService.getEffectById(1L);
        Optional<SignalEffect> inValidSignalEffect = effectService.getEffectById(2L);
        Assertions.assertTrue(validSignalEffect.isPresent());
        Assertions.assertTrue(inValidSignalEffect.isEmpty());
    }

    @Test
    void deleteEffectById(){
        SignalEffect effect = new SignalEffect("effect1","<script>console.log(hellowWorld)</script>","1234","testUser");
        effectService.createEffect(effect);
        Assertions.assertEquals(effectService.getAllEffects().size(),1);
        effectService.deleteEffect(1L);
        Assertions.assertEquals(effectService.getAllEffects().size(),0);
    }

    @Test
    void getEffectsByUser(){
        SignalEffect effect1 = new SignalEffect("testEffect1", "<script>console.log(hellowWorld)</script>", "1234", "testUser");
        effectService.createEffect(effect1);
        SignalEffect effect2 = new SignalEffect("testEffect2", "<script>console.log(hellowWorld)</script>", "9876", "testUser2");
        effectService.createEffect(effect2);

        List<SignalEffect> effects = effectService.getEffectsByUser("1234");
        Assertions.assertEquals(effects.size(), 1);
    }
}