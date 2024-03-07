package com.example.demo.utils.converter;


import com.example.demo.entity.DTO.NewsDTO;
import com.example.demo.entity.PO.NewsPO;
import com.example.demo.enums.NewsTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsConverter {

    public static NewsPO convertNewsDTO2PO(NewsDTO from){
        return NewsPO.builder()
                .id(from.getId())
                .title(from.getTitle())
                .time(from.getTime())
                .content(from.getContent())
                .source(from.getSource())
                .type(NewsTypeEnum.getTypeByValue(from.getType()))
                .intro(from.getIntro())
                .enable(1)
                .build();
    }

    public static List<NewsPO> batchConvertNewsDTO2PO(List<NewsDTO> newsDTOList){
        return newsDTOList.stream().map(NewsConverter::convertNewsDTO2PO).toList();
    }

}
