package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum NewsTypeEnum {

    ENTERTAINMENT(4, "娱乐"),
    SPORTS(3, "体育"),
    MILITARY(2, "军事"),
    EDUCATION(1, "教育"),
    SCIENCE(0, "科技");


    private static final Map<String, NewsTypeEnum> TYPE_MAP = new HashMap<>(NewsTypeEnum.values().length);

    static {
        for (NewsTypeEnum typeEnum : NewsTypeEnum.values()) {
            TYPE_MAP.put(typeEnum.getValue(), typeEnum);
        }
    }


    @Setter
    private Integer id;

    @JsonValue
    @Setter
    private String value;

    public static NewsTypeEnum getTypeByValue(String value){
        return TYPE_MAP.get(value);
    }

}
