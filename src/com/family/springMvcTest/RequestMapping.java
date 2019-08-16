package com.family.springMvcTest;

/**
 * 
 * @author: gzb
 * @date  : 2019年8月14日 下午4:38:18
 *
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)  
public @interface RequestMapping {

    public String value() default "";
}
