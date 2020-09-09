/*CREATING ADAPTER FOR RECYCLERVIEW
 To bind our data to the view or layout
* */
/* -------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : PostAdapter.java
#Package          : algebratemplate
#Author           : Özge AKAT
#Created On       : 2020/09/05

#Description      : Adapter Class for Recyclerview in order to bind data from API to View

#Last Modified By :
#Last Modified On :

#Change Log       :
        -

#Function Params  :
-------------------------------------------------------------------------------------------- */
package com.example.algebratemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import data.Products;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context        context;
    List<Products> productsList;

    public PostAdapter(Context context, List<Products> productsList) {
        this.context     = context;
        this.productsList= productsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txt_name.setText(String.valueOf(productsList.get(position).name));
        holder.txt_price.setText(String.valueOf(productsList.get(position).price));
        Glide.with(context)
                .load(productsList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .apply(new RequestOptions()
                        .centerCrop()).into(holder.image_view);
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}

