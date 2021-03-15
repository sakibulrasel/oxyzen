package com.sadibul.oxyzen.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sadibul.oxyzen.model.ScannedData;

import java.util.List;

/**
 * Created by sakibul.haque
 * on 3/14/2021.
 */
@Dao
public interface OxyzenDao {

    @Insert
    void insertData(ScannedData scanneData);

    @Query("Delete from scanned_data where data =:data")
    void deleteData(String data);

    @Query("Delete from scanned_data")
    void deleteAll();

    @Query("Select * from scanned_data ")
    LiveData<List<ScannedData>> getAllData();


}
