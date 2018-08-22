package com.ssg.redislock.controller;

import com.ssg.redislock.annotation.CacheLock;
import com.ssg.redislock.annotation.LockedComplexObject;
import com.ssg.redislock.annotation.LockedObject;
import com.ssg.redislock.exception.CacheLockException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yang.song on 18-8-22 下午7:46
 * <p>
 * e-mail:yangsong5@xiaomi.com
 */
public class CacheLockInterceptor implements InvocationHandler {
    private static int ERROR_COUNT = 0;
    private Object proxied;

    public CacheLockInterceptor(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);
        if (null == cacheLock){
            System.out.println("no cacheLock annotation");
            return method.invoke(proxied, args);
        }
        //获得方法中参数的注解
        Annotation[][] annotations = method.getParameterAnnotations();
        //根据获取到的参数注解和参数列表获得加锁的参数
        Object lockedObject = getLockedObject(annotations, args);//
       // String objectValue = lockedObject.toString();
        System.out.println("object value=" + lockedObject);
        return null;
    }

    private Object getLockedObject(Annotation[][] annotations, Object[] args) throws CacheLockException {
        if (null == args || 0 == args.length){
            throw new CacheLockException("方法参数为空，没有锁定的对象");
        }
        if (null == annotations || 0 == annotations.length){
            throw new CacheLockException("没有注解的参数");
        }
        //不支持多个参数加锁，仅支持第一个注解为lockedObjeck或者lockedComplexObject的参数
        int index = -1;//标记参数的位置
        System.out.println("args" + args.length);
        for (int i=0; i<annotations.length; i++){
            System.out.println("ssss" + i + annotations[i].length);
//            for (int j=0; j<annotations[i].length; j++){
//                System.out.println(String.format("打印annotations[%s][%s]=%s", i , j, annotations[i][j]));
//                if (annotations[i][j] instanceof LockedComplexObject){//注解为LockedComplexObject
//                    index = i;
//                    try {
//                            return args[i].getClass().getField(((LockedComplexObject)annotations[i][j]).field());
//                        } catch (NoSuchFieldException e) {
//                            return new CacheLockException("注解对象中没有该属性" + ((LockedComplexObject)annotations[i][j]).field());
//                        }
//                    }
//
//                if (annotations[i][j] instanceof LockedObject){
//                    index = i;
//                    break;
//                }
//
//            }
//            if (-1 != index){
//                break;
//            }
        }

//        if (-1 == index){
//            throw new CacheLockException("请指定锁定参数");
//        }
        //return args[index];
        return null;
    }
}
