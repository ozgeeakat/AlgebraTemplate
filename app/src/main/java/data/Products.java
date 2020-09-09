/* --------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : Products.java
#Package          : data
#Author           : Özge AKAT
#Created On       : 2020/09/04

#Description      : Product Data Model which matched with API response model.

#Last Modified By :
#Last Modified On :

#Change Log       :

#Function Params  : N/A
-------------------------------------------------------------------------------------------- */
package data;

import java.util.List;

public class Products {
    public String name;
    public int    price;
    public String image;

    public Products(){}

    public Products(String name, int price, List<Products> myArray, String image) {
        this.name =  name;
        this.price = price;
        this.image = image;
    }

    public int    getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
    public String getName()  {
        return name;
    }

}

