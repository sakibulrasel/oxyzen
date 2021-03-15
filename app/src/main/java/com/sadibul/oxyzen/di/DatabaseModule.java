package com.sadibul.oxyzen.di;

import android.app.Application;

import androidx.room.Room;


import com.sadibul.oxyzen.db.OxyzenDB;
import com.sadibul.oxyzen.db.OxyzenDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Created by sakibul.haque
 * on 14-03-2021
 */
@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static OxyzenDB providePokemonDb(Application application){
        return Room.databaseBuilder(application,OxyzenDB.class,"Oxyzen Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static OxyzenDao provideOxyzenDao(OxyzenDB oxyzenDB){
        return oxyzenDB.oxyzenDao();
    }
}
