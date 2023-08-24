package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.FriendMapper;
import com.lee.onstage.entity.Friend;
import com.lee.onstage.service.FriendService;
import org.springframework.stereotype.Service;

/**
 * (Friend)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("friendService")
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

}

