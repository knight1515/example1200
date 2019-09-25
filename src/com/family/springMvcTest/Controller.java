package com.family.springMvcTest;

/**
 * 自定义Controller注解
 * @author: gzb
 * @date  : 2019年8月14日 下午4:35:01
 *
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
    public String value() default "";
}