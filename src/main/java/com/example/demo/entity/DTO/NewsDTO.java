package com.example.demo.entity.DTO;


import com.example.demo.enums.NewsTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author zhangjingqi
 * @data 2023/05/04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDTO {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情链接
     */
    private String detailUrl;


    /**
     * 时间
     */
    private Long time;

    /**
     * 内容
     */
    private String content;

    /**
     * 来源
     */
    private String source;

    /**
     * 类别
     */
    private NewsTypeEnum type;

    /**
     * 简介
     */
    private String intro;


    public String getType() {
        return Optional.ofNullable(this.type).map(NewsTypeEnum::getValue).orElse(null);
    }

    public void setType(String type) {
        this.type = NewsTypeEnum.getTypeByValue(type);
    }
}
