package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public enum GenderEnum {

    MALE(1, "男"),
    FEMALE(0, "女");


    private static final Map<String, GenderEnum> TYPE_MAP = new HashMap<>(GenderEnum.values().length);

    static {
        for (GenderEnum typeEnum : GenderEnum.values()) {
            TYPE_MAP.put(typeEnum.getValue(), typeEnum);
        }
    }


    @Setter
    @Getter
    private Integer id;

    @JsonValue
    @Setter
    @Getter
    private String value;

    public static GenderEnum getTypeByValue(String value){
        return TYPE_MAP.get(value);
    }

}
