package com.github.chinayinman.common.tools.exception;


import com.github.chinayinman.common.base.constant.ExceptionConstant;

/**
 * @description  自定义JSON异常
 * @author mantou
 */
public class CustomJSONException extends RuntimeException {

    private String info;
    private String code;

    /**
     * 异常码, 异常信息
     * @param code
     * @param info
     */
    public CustomJSONException(String code, String info) {
        super(info);
        this.info = info;
        this.code = code;
    }

    /**
     * 异常信息
     * @param info
     */
    public CustomJSONException(String info) {
        super(info);
        this.info = info;
        this.code = ExceptionConstant.RET_CODE_JSON_EXCEPTION;
    }

    public CustomJSONException() {
        this(ExceptionConstant.RET_CODE_JSON_EXCEPTION, ExceptionConstant.RET_INFO_JSON_EXCEPTION);
    }


}
