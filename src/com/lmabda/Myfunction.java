package com.lmabda;

@FunctionalInterface
public interface Myfunction<T, R> {
    public R getNum(T t1,T t2);
}
