package com.zeng.web.blog.service.impl;

import com.zeng.web.blog.dao.CommentDao;
import com.zeng.web.blog.domain.vo.CommentVo;
import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.service.CommentService;
import com.zeng.web.blog.util.Result;
import com.zeng.web.blog.util.ResultCode;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName CommentServiceImpl
 * @Description TOOD
 * @Date 2019/12/9
 * @Version 1.0
 **/
public class CommentServiceImpl implements CommentService {
    private  CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    @Override
    public Result writeComment(Comment comment) {
        int n = 0;
        try {
            n = commentDao.insert(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (n==1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }

    @Override
    public Result showComment(long articleId) {
        List<CommentVo> commentVoList = new ArrayList<>();
        try {
            commentVoList = commentDao.getCommments(articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (commentVoList != null) {
            return Result.success(commentVoList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
