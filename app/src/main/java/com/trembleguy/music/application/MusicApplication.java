package com.trembleguy.music.application;

import android.app.Application;
import android.content.Intent;

import com.trembleguy.music.service.PlayService;
import com.trembleguy.music.storage.db.DBManager;

/**
 * 自定义Application
 * Created by wcy on 2015/11/27.
 */
public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppCache.get().init(this);
        ForegroundObserver.init(this);
        DBManager.get().init(this);

        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }
}
