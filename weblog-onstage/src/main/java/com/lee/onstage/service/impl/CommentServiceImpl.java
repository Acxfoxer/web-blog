package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.CommentMapper;
import com.lee.onstage.entity.Comment;
import com.lee.onstage.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * (Comment)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

