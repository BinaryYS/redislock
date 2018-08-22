package com.ssg.redislock.annotation;

import java.lang.annotation.*;

/**
 * Created by yang.song on 18-8-22 下午7:41
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedObject {
}
