package com.study.chang.dagger2applicationdemo.component;

import com.study.chang.dagger2applicationdemo.ForActivity;
import com.study.chang.dagger2applicationdemo.activity.MainActivity;
import com.study.chang.dagger2applicationdemo.module.ActivityModule;

import dagger.Subcomponent;

/**
 * 我们要在Activity的Component中继承ApplicationComponent，也就是要让Activity的Component不仅
 * 可以从ActivityModule中查找注入类，还要能从ApplicationModule中查找到注入类。
 * <p>
 * 这里和主分支的方式的区别有两点：
 * 1、不再使用@Component而使用@Subcomponent来注释
 * 2、删除了"dependencies = ApplicationComponent.class"语句
 *
 * @author 2018/6/11 12:02 / changliugang
 */
@ForActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(MainActivity.OtherClass otherClass);

}
