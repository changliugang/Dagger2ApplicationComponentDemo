package com.study.chang.dagger2applicationdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.libs.chang.loglib.Loglg;
import com.study.chang.dagger2applicationdemo.AppApplication;
import com.study.chang.dagger2applicationdemo.R;
import com.study.chang.dagger2applicationdemo.component.ActivityComponent;
import com.study.chang.dagger2applicationdemo.component.ApplicationComponent;
import com.study.chang.dagger2applicationdemo.component.DaggerActivityComponent;
import com.study.chang.dagger2applicationdemo.entity.ActivityBean;
import com.study.chang.dagger2applicationdemo.entity.AppBean;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    /*
        LogCat中的输出可以看到：
            1、Application中注入的mAppBean和mAppBean_以及Activity中注入的mAppBean1、mAppBean2还有
            OtherClass中注入的mAppBean1、mAppBean2这六个对象的地址都是一样的。
            分析：
                1、在Activity和OtherClass中我们可以获取到ApplicationBean对象，说明我们当前的注入方式完成
                   了"Activity从Application继承Component进行注入"的任务。
                2、我们不仅在APP的全局都获取到了ApplicationBean对象，而且得到的都是单例对象，这说明我们在
                   ApplicationModule中对ApplicationBean进行单例注入的方式在全局都是有效的。
            2、Activity中的activityBean和OtherClass中的activityBean对象地址不同。
            分析：
                ActivityBean对象在Activity中和OtherClass中分别注入了两次，所以这两次注入是独立的，它们注
                入的ActivityBean对象是不同的。
     */

    @Inject
    AppBean mAppBean1;
    @Inject
    AppBean mAppBean2;

    @Inject
    ActivityBean mActivityBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppApplication appApplication = (AppApplication) getApplication();
        ApplicationComponent applicationComponent = appApplication.getApplicationComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent).build();
        activityComponent.inject(this);

        Loglg.d(mAppBean1);
        Loglg.d(mAppBean2);
        Loglg.d(mActivityBean);

        OtherClass otherClass = new OtherClass();

    }

    /**
     * 我们接下来就要在Activity中同时注入ActivityBean和ApplicationBean对象了，并且ApplicationBean还
     * 是全局单例的模式，为了扩展测试，我们在Activity中还创建了一个OtherClass，也将ActivityBean和
     * ApplicationComponent都注入进去进行观察：
     */
    public class OtherClass {

        @Inject
        AppBean mAppBean1;
        @Inject
        AppBean mAppBean2;

        @Inject
        ActivityBean mActivityBean;

        public OtherClass() {
            AppApplication appApplication = (AppApplication) getApplication();
            ApplicationComponent applicationComponent = appApplication.getApplicationComponent();
            ActivityComponent activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(applicationComponent).build();
            activityComponent.inject(this);

            Loglg.d(mAppBean1);
            Loglg.d(mAppBean2);
            Loglg.d(mActivityBean);
        }
    }

}
