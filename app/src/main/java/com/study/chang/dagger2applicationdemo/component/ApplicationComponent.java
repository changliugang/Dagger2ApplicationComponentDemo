package com.study.chang.dagger2applicationdemo.component;

import com.study.chang.dagger2applicationdemo.AppApplication;
import com.study.chang.dagger2applicationdemo.module.ApplicationModule;
import com.study.chang.dagger2applicationdemo.entity.AppBean;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 全局Component
 *
 * 在这里请注意两点：
 * 1、由于我们设计要将ApplicationBean作为单例注入，因此ApplicationComponent也需要标记@Singleton标识
 * 2、我们在ApplicationComponent中提供了一个返回值为ApplicationBean对象的方法声明，它的作用是将
 * 该Component中的ApplicationBean对象暴露给其他Component使用，相当于AIDL语言中的方法声明。
 *
 * @author 2018/6/11 11:44 / changliugang
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppApplication appApplication);

    /**
     * 将AppBean开放给其他Component使用
     *
     * @return {@link AppBean}
     */
    AppBean providerAppBean();

    ActivityComponent activityComponent();
}
