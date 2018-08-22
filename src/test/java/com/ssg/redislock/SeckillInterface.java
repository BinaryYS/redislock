package com.ssg.redislock;

import com.ssg.redislock.annotation.CacheLock;
import com.ssg.redislock.annotation.LockedObject;
import com.sun.istack.internal.Nullable;

/**
 * Created by yang.song on 18-8-22 下午8:12
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
public interface SeckillInterface {
    @CacheLock(lockedPrefix = "songsongge")
    public void secKill(@LockedObject Long arg2, String name, String addr);
}
