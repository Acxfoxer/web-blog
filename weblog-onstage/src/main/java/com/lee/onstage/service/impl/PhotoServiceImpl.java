package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.PhotoMapper;
import com.lee.onstage.entity.Photo;
import com.lee.onstage.service.PhotoService;
import org.springframework.stereotype.Service;

/**
 * (Photo)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("photoService")
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

}

