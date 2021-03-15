package com.sadibul.oxyzen.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sadibul.oxyzen.model.ScannedData;


/**
 * Created by sakibul.haque
 * on 3/14/2021.
 */
@Database(entities = {ScannedData.class}, version = 1,exportSchema = false)
public abstract class OxyzenDB extends RoomDatabase {

    public abstract OxyzenDao oxyzenDao();
}
