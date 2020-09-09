/*To initialize our textViews and imageViews
* which will be implemented in our recyclerView.
* */
/* -------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : PostViewHolder.java
#Package          : algebratemplate
#Author           : Özge AKAT
#Created On       : 2020/09/05

#Description      : Initializer for product display in order to show details of the product
                    which will be implemented in recyclerView

#Last Modified By :
#Last Modified On :

#Change Log       :
        -

#Function Params  : (itemView) View base for each product
-------------------------------------------------------------------------------------------- */

package com.example.algebratemplate;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView  txt_name ,txt_price;
    ImageView image_view;
    public PostViewHolder( View itemView) {
        super(itemView);
        txt_name =   itemView.findViewById(R.id.txt_name);
        txt_price =  itemView.findViewById(R.id.txt_price);
        image_view = itemView.findViewById(R.id.image_view);


    }
}