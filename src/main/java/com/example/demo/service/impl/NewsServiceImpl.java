package com.example.demo.service.impl;

import com.example.demo.config.JwtConfig;
import com.example.demo.dao.NewsMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.DTO.NewsDTO;
import com.example.demo.entity.PO.NewsPO;
import com.example.demo.entity.VO.common.ExtInfoPageVO;
import com.example.demo.entity.VO.news.NewsCriteriaVO;
import com.example.demo.service.NewsService;
import com.example.demo.service.UserService;
import com.example.demo.utils.converter.NewsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final JwtConfig jwtConfig;



    private final NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(JwtConfig jwtConfig, NewsMapper newsMapper) {
        this.jwtConfig = jwtConfig;
        this.newsMapper = newsMapper;

    }


    @Override
    public void batchSaveNews(List<NewsDTO> newsDTOList) {
        List<NewsPO> newsPOList = NewsConverter.batchConvertNewsDTO2PO(newsDTOList);
        newsMapper.batchSaveNewsMultiWork(newsPOList);
    }

    @Override
    public ExtInfoPageVO<NewsDTO, Integer> getOnePageNews(NewsCriteriaVO newsCriteriaVO) {
        return null;
    }


}
