package com.study.chang.dagger2applicationdemo.component;

import com.study.chang.dagger2applicationdemo.ForActivity;
import com.study.chang.dagger2applicationdemo.activity.MainActivity;
import com.study.chang.dagger2applicationdemo.module.ActivityModule;

import dagger.Component;

/**
 *  我们要在Activity的Component中继承ApplicationComponent，也就是要让Activity的Component不仅
 *  可以从ActivityModule中查找注入类，还要能从ApplicationModule中查找到注入类：
 * @author 2018/6/11 12:02 / changliugang
 */
@ForActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(MainActivity.OtherClass otherClass);

}
