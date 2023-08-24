package com.lee.onstage.constants;

public enum ResultCode {
    /**
     * 请求t成功
     */
    SUCCESS(200,"访问成功"),
    /**
     * 请求table成功
     */
    TABLE_SUCCESS(0,"访问表成功"),
    /**
     * 请求失败
     */
    CAPTCHE_ERROR(222,"验证码错误"),
    ERROR(201,"请求失败"),
    /**
     * 请求已经被接受
     */
    ACCEPTED(202,"请求已经被接收"),
    /**
     * 操作已经执行成功，但是没有返回数据
     */
    NO_CONTENT(204,"未收到返回数据"),
    /**
     * 资源已被移除
     */
   MOVED_PERM(301,"资源已经失效"),
    /**
     * 重定向
     */
    SEE_OTHER(303,"重定向"),
    /**
     * 资源没有被修改
     */
   NOT_MODIFIED(304,"资源修改失败"),
    /**
     * 参数列表错误（缺少，格式不匹配）
     */
     BAD_REQUEST(400,"参数错误"),
    /**
     * 未授权
     */
     UNAUTHORIZED(401,"用户名或者密码错误"),
    /**
     * 访问受限，授权过期
     */
     FORBIDDEN(403,"认证授权过期,请重新认证"),
    /**
     * 资源，服务未找到
     */
     NOT_FOUND(404,"找不到服务"),
    /**
     * 不允许的http方法
     */
     BAD_METHOD(405,"不允许的请求"),
    /**
     * 资源冲突，或者资源被锁
     */
     CONFLICT(409,"资源禁止访问"),
    /**
     * 不支持的数据，媒体类型
     */
     UNSUPPORTED_TYPE(415,"不支持的数据"),
    /**
     * 接口未实现
     */
     NOT_IMPLEMENTED(501,"接口未实现");
    private final int value;
    private final String msg;

    private ResultCode(int value,String msg) {
        this.value=value;
        this.msg=msg;
    }

    public int getValue() {
        return value;
    }
    public String getMsg(){
        return msg;
    }
}
