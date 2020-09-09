/**CREATING RETROFIT API INTERFACE
 * takes menu items
 * from an API endpoint with a GET request.
 * */
package com.example.algebratemplate;

import java.util.List;
import data.Products;
import retrofit2.http.GET;
import io.reactivex.Observable;

public interface GetProductMenu {
    @GET("/menu/")
    Observable<List<Products>> getProducts();

}
