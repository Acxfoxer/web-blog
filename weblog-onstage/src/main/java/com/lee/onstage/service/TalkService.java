package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TalkVO;

/**
 * (Talk)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
public interface TalkService extends IService<Talk>{
    /**
     * 获取当前说说及其对应点赞量,评论量
     * @param current
     * @param size
     * @return
     */
    PageResult<TalkVO> listTalkVO(int current, int size);
}

