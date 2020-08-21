package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText ed;
   // TextView tv;
    Button btn;
    static RequestQueue requestQueue;
    MovieAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.edit1);
        recyclerView = findViewById(R.id.recyclerView1);
        adapter = new MovieAdapter();
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest();
            }
        });
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    private void makeRequest() {
        String url = ed.getText().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);
                        printLog("응답 >> \n" + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        printLog("에러 >> \n" + error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        //printTv("요청보냄.");
        Log.i("Movies", "요청보냄.");
    }

    private void processResponse(String response) {
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response, MovieList.class);
        //printTv("영화정보의 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());
        printLog("영화정보의 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());

        for(int i=0; i<movieList.boxOfficeResult.dailyBoxOfficeList.size(); i++) {
            Movie movie = movieList.boxOfficeResult.dailyBoxOfficeList.get(i);
           adapter.addItem(movie);
        }
        adapter.notifyDataSetChanged();

    }

    private void printLog(String data) {
        Log.d("Movie Info", data);
    }

   /* private void printTv(String data) {

        //tv.append(data + "\n");
    }*/
}