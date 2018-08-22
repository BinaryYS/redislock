package com.ssg.redislock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang.song on 18-8-22 下午8:14
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
public class SecKillImpl implements SeckillInterface {
   private static Map<Long, Long> inventory;
   static {
       inventory = new HashMap<>();
       inventory.put(1000001L, 10000L);
       inventory.put(1000002L, 10000L);

   }
    @Override
    public void secKill(Long arg2, String name, String addr) {
        reduceInventory(arg2);
    }

    public Long reduceInventory(Long commodityId){
       inventory.put(commodityId, inventory.get(commodityId) -1);
       return inventory.get(commodityId);
    }
}
