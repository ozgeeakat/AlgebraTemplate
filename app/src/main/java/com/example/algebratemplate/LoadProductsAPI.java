//fetch API and set data for RecyclerView
// to implement CompositeDisposable to dispose the data once our activity is destroyed
/* -------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : LoadProductsAPI.java
#Package          : algebratemplate
#Author           : Özge AKAT
#Created On       : 2020/09/05

#Description      : Retrofit API class for Product retrieval from REST API

#Last Modified By : Özge AKAT
#Last Modified On : 2020/09/07

#Change Log       : fetchData() function RxJava implementation. Line 56
        -

#Function Params  : List<Products> products --> Product Data Model Array for Api Response
-------------------------------------------------------------------------------------------- */

package com.example.algebratemplate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import data.Products;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class LoadProductsAPI extends AppCompatActivity{

        GetProductMenu      api;
        RecyclerView        recycler_products;
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity);

            //initialization API
            Retrofit retrofit = ProductInstances.getInstance();
            api = retrofit.create(GetProductMenu.class);

            //View
            recycler_products = findViewById(R.id.recycler_products);
            recycler_products.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            recycler_products.setLayoutManager(llm);
            fetchData();
        }
        private void fetchData(){
            compositeDisposable.add(api.getProducts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<Products>>() {
                        @Override
                        public void accept(List<Products> productsList) throws Exception {
                            displayProducts(productsList);
                        }
                    }));
        }
        private void displayProducts(List<Products> products) {
            runOnUiThread(()-> {
                PostAdapter adapter = new PostAdapter(this,products);
                recycler_products.setAdapter(adapter);
            });
        }
        @Override
        protected void onStop() {
            compositeDisposable.clear();
            super.onStop();
        }
    }
