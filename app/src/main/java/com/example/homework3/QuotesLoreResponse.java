package com.example.homework3;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuotesLoreResponse {
    @SerializedName("data")
    @Expose
    private List<Quotes> data = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public List<Quotes> getData() {return data;}
    public  void setData(List<Quotes> data) { this.data = data; }
    public Info getInfo(){return info;}
    public void setInfo(Info info) {this.info = info;}

}