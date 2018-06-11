package com.study.chang.dagger2applicationdemo.module;

import com.study.chang.dagger2applicationdemo.entity.ActivityBean;

import dagger.Module;
import dagger.Provides;

/**
 * @author 2018/6/11 11:59 / changliugang
 */
@Module
public class ActivityModule {

    @Provides
    public ActivityBean providerActivityBean(int count) {
        return new ActivityBean(count);
    }

    @Provides
    public int providerActivityBeanCount() {
        return 1990;
    }
}
