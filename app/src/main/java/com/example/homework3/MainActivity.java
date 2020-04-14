package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    public static final String ARG_ITEM_ID = "item id";
    private static Quotes mQuotes;
    private TextView mQuotestext;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io").addConverterFactory(GsonConverterFactory.create()).build();
        QuotesService service = retrofit.create(QuotesService.class);
        Call<QuotesLoreResponse> quotesCall = service.getQuotes();

        quotesCall.enqueue(new Callback<QuotesLoreResponse>() {
            @Override
            public void onResponse(Call<QuotesLoreResponse> call, Response<QuotesLoreResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "on response: success ");
                    List<Quotes> quotes = response.body().getData();
                    for (int i = 0; i < quotes.size(); i++) {
                        mQuotes.setValue(quotes.get(i).getValue());
                    }
                } else {
                    Log.d(TAG, "on response : error is " + response.errorBody());
                }
                updateUI();
            }


            @Override
            public void onFailure(Call<QuotesLoreResponse> call, Throwable t) {
                Log.d(TAG, "onfailure: failure " + t.getLocalizedMessage());
            }
        });
    }

    private void updateUI(){
        if (mQuotes != null){
            mQuotestext = findViewById(R.id.text1);
            mButton = findViewById(R.id.button);
            mButton.setOnClickListener(v -> mQuotestext.setText(mQuotes.getValue()));
        }
    }
}



