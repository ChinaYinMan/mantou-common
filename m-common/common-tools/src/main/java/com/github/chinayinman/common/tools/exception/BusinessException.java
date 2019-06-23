package com.github.chinayinman.common.tools.exception;


import com.github.chinayinman.common.base.constant.ExceptionConstant;

/**
 * @description 业务异常
 * @author mantou
 */
public class BusinessException extends RuntimeException {

    private String info;
    private String code;

    /**
     * 异常码, 异常信息
     * @param code
     * @param info
     */
    public BusinessException(String code, String info) {
        super(info);
        this.info = info;
        this.code = code;
    }

    /**
     * 异常信息
     * @param info
     */
    public BusinessException(String info) {
        super(info);
        this.info = info;
        this.code = ExceptionConstant.RET_CODE_BUSINESS_EXCEPTION;
    }

    public BusinessException() {
        this(ExceptionConstant.RET_CODE_BUSINESS_EXCEPTION, ExceptionConstant.RET_INFO_BUSINESS_EXCEPTION);
    }


}
