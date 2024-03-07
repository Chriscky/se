package com.example.demo.entity.VO.news;


import com.example.demo.enums.NewsTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangjingqi
 * @data 2023/05/04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsCriteriaVO {
    /**
     * 标题（模糊搜索，可为null）
     */
    private String title;

    /**
     * 类别
     */
    private NewsTypeEnum type;

    /**
     * 来源列表（可为null）
     */
    private List<String> sources;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 页的size
     */
    private Integer pageSize;
}
