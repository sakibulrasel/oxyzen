package com.sadibul.oxyzen.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created By sakibul.haque on 14-03-2021
 */
@Entity(tableName = "scanned_data")
public class ScannedData
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String data;
    private String lat;
    private String lan;

    public ScannedData(String data, String lat, String lan) {
        this.data = data;
        this.lat = lat;
        this.lan = lan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }
}
