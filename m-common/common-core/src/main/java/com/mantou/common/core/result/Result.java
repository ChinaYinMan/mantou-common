package com.mantou.common.core.result;


import com.mantou.common.core.constants.ExceptionConstant;

import java.io.Serializable;


/**
 * 项目统一响应结果类
 * @author mantou
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4559672604634663976L;
    /**
     * 返回码
     */
    private String retCode;
    /**
     * 返回基础信息
     */
    private String retInfo;

    /**
     * 返回数据
     */
    private T data;


    /**------------------------------------------------------操作类方法-----------------------------------------------------**/
    /**
     * 操作成功 - 构造方法
     * @return
     */
    public static <T> Result<T> success() {
        return new Result(ExceptionConstant.RET_CODE_SUCCESS, ExceptionConstant.RET_INFO_SUCCESS);
    }

    /**
     * 操作成功 - 构造方法
     * @param data
     * @return
     */
    public static <T> Result<T> success(Object data) {
        return new Result(ExceptionConstant.RET_CODE_SUCCESS, ExceptionConstant.RET_INFO_SUCCESS, data);
    }

    /**
     * 操作失败 - 构造方法
     * @return
     */
    public static <T> Result<T> failed() {
        return new Result(ExceptionConstant.RET_CODE_FAILED, ExceptionConstant.RET_INFO_FAILED);
    }

    /**
     * 操作失败 - 构造方法 自定义返回基础信息
     * @return
     */
    public static <T> Result<T> failed(String retInfo) {
        return new Result(ExceptionConstant.RET_CODE_FAILED, retInfo);
    }

    /**
     * 操作是否成功 - 构造方法
     */
    public static <T> Result<T> isSuccess(boolean isSuccess, String errorMessage, T data) {
        return isSuccess ? Result.<T>failed(errorMessage) : Result.<T>success(data);
    }
    /**------------------------------------------------------操作类方法-----------------------------------------------------**/


    /**----------------------------------------------------服务/业务类方法----------------------------------------------------**/
    /**
     * 服务异常 - 构造方法
     * @return
     */
    public static <T> Result<T> serverException() {
        return new Result(ExceptionConstant.RET_CODE_SERVER_EXCEPTION, ExceptionConstant.RET_INFO_SERVER_EXCEPTION);
    }

    /**
     * 服务异常 - 构造方法 自定义返回基础信息
     * @return
     */
    public static <T> Result<T> serverException(String retInfo) {
        return new Result(ExceptionConstant.RET_CODE_SERVER_EXCEPTION, retInfo);
    }

    /**
     * 业务异常 - 构造方法
     * @return
     */
    public static <T> Result<T> businessException() {
        return new Result(ExceptionConstant.RET_CODE_BUSINESS_EXCEPTION, ExceptionConstant.RET_INFO_BUSINESS_EXCEPTION);
    }

    /**
     * 业务异常 - 构造方法 自定义返回基础信息
     * @param retInfo
     * @return
     */
    public static <T> Result<T> businessException(String retInfo) {
        return new Result(ExceptionConstant.RET_CODE_BUSINESS_EXCEPTION, retInfo);
    }

    /**
     * 参数无意义 - 构造方法
     * @return
     */
    public static <T> Result<T> paramsEmpty() {
        return new Result(ExceptionConstant.RET_CODE_PARAM_EMPTY, ExceptionConstant.RET_INFO_PARAM_EMPTY);
    }
    /**----------------------------------------------------服务/业务类方法----------------------------------------------------**/


    /**-----------------------------------------------------自定义类方法------------------------------------------------------**/
    /**
     * 自定义返回码, 返回基础信息 - 构造方法
     * @param retCode
     * @param retInfo
     */
    public Result(String retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    /**
     * 自定义返回码, 返回基础信息, 返回数据 - 构造方法
     * @param retCode
     * @param retInfo
     * @param data
     */
    public Result(String retCode, String retInfo, T data) {
        this.retCode = retCode;
        this.retInfo = retInfo;
        this.data = data;
    }

    /**
     * 自定义返回码, 返回基础信息 - Set方法
     * @param retCode
     * @param retInfo
     */
    public void setCodeInfo(String retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }
    /**------------------------------------------------------自定义类方法----------------------------------------------------**/


}
