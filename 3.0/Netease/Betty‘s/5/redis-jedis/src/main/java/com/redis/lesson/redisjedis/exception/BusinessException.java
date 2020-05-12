package com.redis.lesson.redisjedis.exception;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BusinessException.java
 * @Description TODO
 * @createTime 2020年05月12日 16:29:00
 */
public class BusinessException extends RuntimeException {
    //异常编号，信息说明
    private final int messageCode;
    private final String detailMessage;

    public BusinessException(int messageCode,String message ) {
        super(message);
        this.messageCode = messageCode;
        this.detailMessage = message;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
