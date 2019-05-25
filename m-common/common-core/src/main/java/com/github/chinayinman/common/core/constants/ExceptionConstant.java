package com.github.chinayinman.common.core.constants;

/**
 * 异常定义-常量
 *
 * @author mantou
 */
public class ExceptionConstant {

    /**----------------------------------------------------操作类--------------------------------------------------------*/
    /**
     * 操作成功
     */
    public static final String RET_CODE_SUCCESS = "00200";
    public static final String RET_INFO_SUCCESS = "Operate Successfully ( 操作成功 ) !";
    /**
     * 操作失败
     */
    public static final String RET_CODE_FAILED = "00500";
    public static final String RET_INFO_FAILED = "Operate Failure ( 操作失败 ) !";
    /**-----------------------------------------------------操作类-------------------------------------------------------*/


    /**---------------------------------------------------服务/业务类-------------------------------------------------------*/
    /**
     * 业务异常
     */
    public static final String RET_CODE_BUSINESS_EXCEPTION = "00010";
    public static final String RET_INFO_BUSINESS_EXCEPTION = "Business Exception ( 业务异常 ) !";

    /**
     * 服务异常
     */
    public static final String RET_CODE_SERVER_EXCEPTION = "01000";
    public static final String RET_INFO_SERVER_EXCEPTION = "Server Exception ( 服务异常 ) !";
    /**---------------------------------------------------服务/业务类-------------------------------------------------------*/


    /**----------------------------------------------------请求/参数类----------------------------------------------------*/
    /**
     * HTTP请求不正确定义: 后端接口HTTP.METHOD定义与前端发起的HTTP.METHOD不符,则视为HTTP请求不正确
     */
    public static final String RET_CODE_REQUEST_EXCEPTION = "00001";
    public static final String RET_INFO_REQUEST_EXCEPTION = "Current Request Method ( GET POST PUT DELETE ) Not Supported ( 不支持当前请求方法 ) !";

    /**
     * 参数无意义empty定义: 前端请求参数无意义(null, "", []等, 视为empty)
     */
    public static final String RET_CODE_PARAM_EMPTY = "00002";
    public static final String RET_INFO_PARAM_EMPTY = "Parameters Is Empty ( 参数无意义 ) !";
    /**-----------------------------------------------------请求/参数类----------------------------------------------------*/


}
