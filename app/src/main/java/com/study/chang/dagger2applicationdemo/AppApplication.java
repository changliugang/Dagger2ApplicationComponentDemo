package com.study.chang.dagger2applicationdemo;

import android.app.Application;

import com.libs.chang.loglib.Loglg;
import com.study.chang.dagger2applicationdemo.component.ApplicationComponent;
import com.study.chang.dagger2applicationdemo.component.DaggerApplicationComponent;
import com.study.chang.dagger2applicationdemo.entity.AppBean;

import javax.inject.Inject;

/**
 * 全局上下文
 *
 * @author 2018/6/11 11:39 / changliugang
 */
public class AppApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    AppBean mAppBean;
    @Inject
    AppBean mAppBean_;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplicationComponent == null)
            mApplicationComponent = DaggerApplicationComponent.create();
        mApplicationComponent.inject(this);

        Loglg.d(mAppBean);
        Loglg.d(mAppBean_);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
