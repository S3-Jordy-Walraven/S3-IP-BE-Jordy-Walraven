package com.example.springbooteffectappbackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="Effect")
public class SignalEffect {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "EffectName can not be null")
    private String effectName;

    @Lob
    @Column(length = 500000)
    @NotBlank(message = "Effect can not be null")
    public String effectContent;

    @Column(name="userId")
    @NotBlank(message = "User needs to be logged in")
    private  String subjectId;
    @NotBlank(message = "User needs to be logged in")
    private String creatorName;

}
