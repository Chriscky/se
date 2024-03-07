package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public enum SenderTypeEnum {

   USER("user"),
   SYSTEM("system"),
    BOT("assistant");

    @JsonValue
    @Setter
    @Getter
    private String value;
}
