package com.ssg.redislock.annotation;

import java.lang.annotation.*;

/**
 * Created by yang.song on 18-8-22 下午7:40
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedComplexObject {
    String field() default "";//含有成员变量的复杂对象中需要加锁的成员变量，如一个商品对象的商品ID

}
