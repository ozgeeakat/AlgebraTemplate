package com.example.algebratemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.IOException;
import java.util.List;
import data.Products;
import io.reactivex.Observable;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LoadProductsAPITest {
    @Mock
    GetProductMenu api;

    @InjectMocks
    LoadProductsAPI loadProductsAPI;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        Gson gson = new GsonBuilder().setLenient().create();
        mockWebServer.enqueue(new MockResponse().setBody("[{\"image\":\"https://media3.s-nbcnews.com/j/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p_67dfb6820f7d3898b5486975903c2e51.fit-760w.jpg\",\"name\":\"Latte\",\"price\":5},{\"image\":\"https://media3.s-nbcnews.com/j/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p_67dfb6820f7d3898b5486975903c2e51.fit-760w.jpg\",\"name\":\"Espresso\",\"price\":8},{\"image\":\"https://media3.s-nbcnews.com/j/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p_67dfb6820f7d3898b5486975903c2e51.fit-760w.jpg\",\"name\":\"Americano\",\"price\":3}]"));
        Retrofit retrofit = ProductInstances.getInstance();
        api = retrofit.create(GetProductMenu.class);

        Observable<List<Products>> call = api.getProducts();
        assertTrue(call != null);
        mockWebServer.shutdown();
    }
}

