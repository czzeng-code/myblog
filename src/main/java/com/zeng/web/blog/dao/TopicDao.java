package com.zeng.web.blog.dao;

import com.zeng.web.blog.domain.vo.TopicVo;
import com.zeng.web.blog.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZENG
 */
public interface TopicDao {
    /**
     * 批量新增专题
     *
     * @param topicList
     * @return
     * @throws SQLException
     */
    void batchInsert(List<Topic> topicList) throws SQLException;

    /**
     * 获取所有专题
     *
     * @return
     * @throws SQLException
     */
    List<Topic> selectAll() throws SQLException;

    /**
     * 获取热门专题
     *
     * @return
     * @throws SQLException
     */
    List<Topic> selectHotTopics() throws SQLException;

    /**
     * 分页获取专题
     *
     * @param currentPage
     * @return
     * @throws SQLException
     */
    List<Topic> selectByPage(int currentPage, int count) throws SQLException;

    /**
     * 根据id获取专题详情
     *
     * @param id
     * @return
     * @throws SQLException
     */
    TopicVo getTopic(long id) throws SQLException;

    /**
     * 模糊搜索专题
     *
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Topic> selectByKeywords(String keywords) throws SQLException;
}
