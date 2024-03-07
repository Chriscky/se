package com.example.demo.service;


import com.example.demo.entity.DTO.NewsDTO;
import com.example.demo.entity.VO.common.ExtInfoPageVO;
import com.example.demo.entity.VO.news.NewsCriteriaVO;


import java.util.List;

public interface NewsService {

    /**
     * 批量添加新闻
     * @param newsDTOList 新闻信息
     *
     */
    void batchSaveNews(List<NewsDTO> newsDTOList);

    /**
     * 分页查找新闻

    @return
     *
     */
    ExtInfoPageVO<NewsDTO,  Integer> getOnePageNews(NewsCriteriaVO newsCriteriaVO);

}
