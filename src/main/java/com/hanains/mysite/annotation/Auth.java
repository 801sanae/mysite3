package com.hanains.mysite.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 시점과 위치
 * detect되는 시점 
 * 적용해야될 위치
 */

@Target(ElementType.METHOD)//어디다가 붙이는지//메소드에 붙여라! 라는 위치 설정
@Retention(RetentionPolicy.RUNTIME)//runtime 때 Detect된다.

public @interface Auth {

}
