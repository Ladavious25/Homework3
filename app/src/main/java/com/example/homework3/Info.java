package com.example.homework3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("quotes_num")
    @Expose
    private Integer quotesNum;
    @SerializedName("time")
    @Expose
    private Integer time;
    public Integer getQuotesNum(){
        return quotesNum;
    }
    private void setQuotesNum(Integer quotesNum){
        this.quotesNum = quotesNum;
    }
    public Integer getTime(){
        return time;
    }
    private void setTime(Integer time){
        this.time = time;

    }
}
