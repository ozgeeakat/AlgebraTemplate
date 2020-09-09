/*CREATING RETROFIT CLIENT
It is a singleton class.
To add our baseUrl and create an instance of our
RetrofitClient. The base URL is needed for all
service calls and a converter factory to take care of
parsing the data and to receive the responses.
* */
/* -------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : ProductInstances.java
#Package          : algebratemplate
#Author           : Özge AKAT
#Created On       : 2020/09/05

#Description      : Singleton class for Retrofit Client.

#Last Modified By :
#Last Modified On :

#Change Log       :
        -

#Function Params  : BASE_URL --> Api base URL
                    ourInstance --> Retrofit instance. If null? created new instance and return.
                    If not null? return current instance.
-------------------------------------------------------------------------------------------- */
package com.example.algebratemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.APIUrl;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductInstances {
    private static Retrofit ourInstance;
    private static String BASE_URL = APIUrl.getProductAPIUrl();

    public static Retrofit getInstance() {
        if(ourInstance == null){
            Gson gson   = new GsonBuilder().setLenient().create();
            ourInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).
                            addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        }
        return ourInstance;
    }

    private ProductInstances() {}
}