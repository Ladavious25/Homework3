package com.example.homework3;

import retrofit2.http.GET;
import retrofit2.Call;

public interface QuotesService {
    @GET("/jokes/random")
    Call<Quotes>getQuotes();
}
