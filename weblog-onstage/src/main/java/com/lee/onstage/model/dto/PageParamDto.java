package com.lee.onstage.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页dto
 * @author lei
 */
@ApiModel("分页条件")
public class PageParamDto {
    @ApiModelProperty("页码条数")
    private Integer size;
    @ApiModelProperty("当前页码")
    private Integer current;
    /**
     * 搜索内容
     */
    @ApiModelProperty(value = "搜索内容")
    private String keyword;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getOptModule() {
        return optModule;
    }

    public void setOptModule(String optModule) {
        this.optModule = optModule;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 是否禁用 (0否 1是)
     */
    @ApiModelProperty(value = "是否禁用 (0否 1是)")
    private Integer isDisable;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    /**
     * 标签id
     */
    @ApiModelProperty(value = "标签id")
    private Integer tagId;

    /**
     * 相册id
     */
    @ApiModelProperty(value = "相册id")
    private Integer albumId;

    /**
     * 类型id
     */
    @ApiModelProperty(value = "类型id")
    private Integer typeId;

    /**
     * 评论主题类型
     */
    @ApiModelProperty(value = "评论主题类型")
    private Integer commentType;

    /**
     * 文章类型 (1原创 2转载 3翻译)
     */
    @ApiModelProperty(value = "文章类型 (1原创 2转载 3翻译)")
    private Integer articleType;

    /**
     * 登录类型
     */
    @ApiModelProperty(value = "登录类型")
    private Integer loginType;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    /**
     * 操作模块
     */
    @ApiModelProperty(value = "操作模块")
    private String optModule;

    /**
     * 是否删除 (0否 1是)
     */
    @ApiModelProperty(value = "是否删除 (0否 1是)")
    private Integer isDelete;

    /**
     * 是否通过 (0否 1是)
     */
    @ApiModelProperty(value = "是否通过 (0否 1是)")
    private Integer isCheck;

    /**
     * 文章状态 (1公开 2私密 3草稿)
     * 任务状态 (0运行 1暂停)
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 任务组名
     */
    @ApiModelProperty(value = "任务组名")
    private String taskGroup;

    /**
     * 调用目标
     */
    @ApiModelProperty(value = "调用目标")
    private String invokeTarget;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
}
