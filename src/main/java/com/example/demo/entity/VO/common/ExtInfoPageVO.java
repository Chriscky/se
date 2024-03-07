package com.example.demo.entity.VO.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @param <T> 页内容参数
 * @author zhangjingqi
 * @description 分页模型 value object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtInfoPageVO<T, U> {

	/**
	 * 内容列表
	 */
	private List<T> contentList;
	/**
	 * 页数
	 */
	private Integer pageCount;
	/**
	 * 页大小
	 */
	private Integer pageSize;
	/**
	 * 当前的页码
	 */
	private Integer pageNo;
	/**
	 * 额外信息
	 */
	private U extInfo;
}
