package com.ssg.redislock;

import com.ssg.redislock.controller.CacheLockInterceptor;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by yang.song on 18-8-22 下午8:21
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
public class SecKillTest {
    private static Long commodityId1 = 1000001L;
    private static Long commodityId2 = 1000002L;

    @Test
    public void testAnnotation(){
        SecKillImpl secKill = new SecKillImpl();
        SeckillInterface proxy = (SeckillInterface) Proxy.newProxyInstance(SeckillInterface.class.getClassLoader(), new Class[]{SeckillInterface.class},
                new CacheLockInterceptor(secKill));
        proxy.secKill(commodityId1, "sdd","test");
    }
}
