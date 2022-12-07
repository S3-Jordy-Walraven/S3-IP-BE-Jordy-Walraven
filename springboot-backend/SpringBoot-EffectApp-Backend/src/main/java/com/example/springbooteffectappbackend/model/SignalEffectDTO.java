package com.example.springbooteffectappbackend.model;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

public class SignalEffectDTO {
    public String effectName;
    public String effectContent;
    public  String subjectId;
    public String creatorName;
}
