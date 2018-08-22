package com.ssg.redislock.exception;

/**
 * Created by yang.song on 18-8-22 下午7:43
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
public class CacheLockException extends Throwable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg){
        this.msg = msg;
    }
    public CacheLockException(){
    }

}
