package com.ssg.redislock.annotation;

import java.lang.annotation.*;

/**
 * Created by yang.song on 18-8-22 下午7:35
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {
    String lockedPrefix() default "";//redis锁prefix
    int eixpireTime() default 100000;//key 在redis中
    long timeOut() default 2000;//锁时间
}
