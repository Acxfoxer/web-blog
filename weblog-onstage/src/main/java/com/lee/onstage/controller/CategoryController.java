package com.lee.onstage.controller;

import com.lee.onstage.annotation.VisitLogger;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CategoryBackVO;
import com.lee.onstage.model.vo.CategoryVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @ApiOperation(value = "后台查看分类列表")
    @RequestMapping("/admin/category/list")
    public ResponseResult<PageResult<CategoryBackVO>> listCategoryBackVo(PageParamDto pageParamDto){
        return ResponseResult.success(categoryService.listCategoryBackVo(pageParamDto));
    }

    @VisitLogger("查看文章分类")
    @ApiOperation(value = "查看文章分类列表")
    @GetMapping("/category/list")
    public ResponseResult<List<CategoryVO>> listCategoryVo(){
        return ResponseResult.success(categoryService.listCategoryVo());
    }
}
