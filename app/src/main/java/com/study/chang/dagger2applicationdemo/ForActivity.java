package com.study.chang.dagger2applicationdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 为什么要添加这个修饰呢？因为当前Component所继承的ApplicationComponent中包含Singleton的注释，所
 * 以ApplicationComponent的子类Component的作用范围不能高于ApplicationComponent的作用范围，因此需
 * 要对ActivityComponent也添加Scope的限定。
 *
 * @author 2018/6/11 12:01 / changliugang
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ForActivity {
}
