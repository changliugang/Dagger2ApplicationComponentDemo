package com.study.chang.dagger2applicationdemo.module;

import com.study.chang.dagger2applicationdemo.entity.AppBean;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author 2018/6/11 11:47 / changliugang
 */
@Module
public class ApplicationModule {

    @Singleton
    @Provides
    public AppBean providerAppBean(String desc){
        return new AppBean(desc);
    }

    @Provides
    public String providerDesc(){
        return "Just Do It";
    }
}
