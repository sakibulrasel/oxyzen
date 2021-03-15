package com.sadibul.oxyzen.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sadibul.oxyzen.model.ScannedData;
import com.sadibul.oxyzen.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By sakibul.haque on 15-03-2021
 */
public class HomeViewModel extends ViewModel
{

    private static final String TAG = "Home View Model";

    private Repository repository;
    private LiveData<List<ScannedData>> dataList = null;

    @ViewModelInject
    public HomeViewModel(Repository repository)
    {
        this.repository = repository;
        dataList = repository.getAllData();
    }

    public void insertData(ScannedData data)
    {
        repository.insertData(data);
    }

    public void deleteData(String data)
    {
        repository.deleteData(data);
    }

    public void deleteAll()
    {
        repository.deleteAll();
    }

    public void getAllData()
    {
        dataList = repository.getAllData();
    }

    public LiveData<List<ScannedData>> getDataList(){
        return dataList;
    }
}
