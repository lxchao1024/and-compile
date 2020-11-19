package com.guagua.test;

import android.app.Application;
import android.content.Context;

/**
 * Copyright (C), 2020-2020, guagua
 *
 * @author lxc
 * Date: 2020/11/18 13:49
 * Version: 1.0.0
 * Description:
 * History:
 * <author> <time> <version> <desc>
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        new Thread(() -> {
            Utils.getAndroidSingle(this);
            Utils.getCompileDan(this);
            Utils.getCompileDuo(this);
            Utils.getCompilePd(this, "bianyi_pd.xls");
            Utils.getCompilePd(this, "bianyi_tk.xls");
        }).start();
    }

    public static Context getAppContext() {
        return context;
    }
}
