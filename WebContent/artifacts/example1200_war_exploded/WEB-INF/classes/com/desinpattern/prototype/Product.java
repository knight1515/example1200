package com.desinpattern.prototype;

public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClont();
}
