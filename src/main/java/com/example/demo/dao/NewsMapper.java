package com.example.demo.dao;



import com.example.demo.entity.PO.NewsPO;
import com.example.demo.entity.PO.UserPO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangjingqi
 * @date 2024/03/03
 */
@Mapper
public interface NewsMapper {


	/**
	 * 添加一条新闻
	 * @param  newsPO News信息对象
	 * @return 插入影响的行数
	 */
	int saveNews(NewsPO newsPO);

	/**
	 * 批量添加新闻(一个事务，但是可能会因为单条sql语句过长出现问题)
	 * @param newsPOs News信息对象
	 *                @return 插入影响的行数
	 */
	int batchSaveNews(List<NewsPO> newsPOs);

	/**
	 * 批量添加新闻(会为每条语句生成一个事务，但是避免了单条sql语句过长可能产生的问题)
	 * @param newsPOs News信息对象
	 *                @return 插入影响的行数
	 */
	int batchSaveNewsMultiWork(List<NewsPO> newsPOs);

	/**
	 * 分页查找新闻
	 * @param offset  偏移量
	 * @param pageSize 每页大小
	 * @param type 新闻类型
	 * @param sources 新闻来源
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 *
	 * @return
	 */
	List<NewsPO> getOnePageNews(@Param("offset") long offset,
								@Param("pageSize") int pageSize,
								@Param("type") String type,
								@Param("source") List<String> sources,
								@Param("startTime") Long startTime,
								@Param("endTime") Long endTime);

	/**
	 * 通过title查新闻
	 * @param title 新闻标题
	 * @return
	 */
	List<NewsPO> findNewsByTitle(String title);

	/**
	 * 通过source筛选新闻
	 * @param sources 新闻来源
	 *              @return
	 */
	List<NewsPO> findNewsBySource(List<String> sources);


	/**
	 * 通过time范围筛选新闻
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	List<NewsPO> findNewsByTimeRange(Long startTime, Long endTime);
	/**
	 * 通过type查新闻
	 * @param type 新闻类型
	 * @return
	 */
	NewsPO findNewsByType(String type);

	/**
	 * 通过id查新闻
	 * @param id 新闻id
	 * @return
	 */
	NewsPO findNewsById(Integer id);

	/**
	 * 更新新闻信息
	 * @param news
	 * @return 更新影响的行数
	 */
	int updateNews(NewsPO news);

	/**
	 * 删除新闻
	 * @param id
	 * @return 删除影响的行数
	 */
	int disableNews(Integer id, Long updatedAt);


	/**
	 * 查找所有新闻
	 * @return
	 */
	List<NewsPO> findAllNews();




}
