package com.sadibul.oxyzen.repository;

import androidx.lifecycle.LiveData;

import com.sadibul.oxyzen.db.OxyzenDao;
import com.sadibul.oxyzen.model.ScannedData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created By sakibul.haque on 15-03-2021
 */
public class Repository
{
    private OxyzenDao oxyzenDao;

    @Inject
    public Repository(OxyzenDao oxyzenDao)
    {
        this.oxyzenDao = oxyzenDao;
    }

    public void insertData(ScannedData scannedData)
    {
        oxyzenDao.insertData(scannedData);
    }

    public void deleteData(String  data)
    {
        oxyzenDao.deleteData(data);
    }

    public void deleteAll()
    {
        oxyzenDao.deleteAll();
    }

    public LiveData<List<ScannedData>> getAllData()
    {
        return oxyzenDao.getAllData();
    }
}
