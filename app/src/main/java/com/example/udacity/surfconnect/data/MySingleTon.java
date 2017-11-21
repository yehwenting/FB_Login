package com.example.udacity.surfconnect.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Yehwenting on 2017/11/15.
 */

public class MySingleTon {
    private static MySingleTon mInstance;
    private RequestQueue requestQueue;
    private static Context mctx;

    private MySingleTon(Context context){
        this.mctx=context;
        this.requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleTon getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleTon(context);
        }
        return mInstance;
    }

    public<T> void addToRequestque(Request<T> request){
        requestQueue.add(request);
    }

}
