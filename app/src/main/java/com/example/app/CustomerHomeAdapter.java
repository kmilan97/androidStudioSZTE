package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.ViewHolder> {

    private Context mcontext;
    private List<UpdateExtensionsModel> updateExtensionsModellist;
    DatabaseReference databaseReference;

    public CustomerHomeAdapter(Context context , List<UpdateExtensionsModel> updateExtensionsModelslist){

        this.updateExtensionsModellist = updateExtensionsModelslist;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public CustomerHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.customer_menudish,parent,false);
        return new CustomerHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHomeAdapter.ViewHolder holder, int position) {

        final UpdateExtensionsModel updateExtensionsModel = updateExtensionsModellist.get(position);
        Glide.with(mcontext).load(updateExtensionsModel.getImageURL()).into(holder.imageView);
        holder.Dishname.setText(updateExtensionsModel.getPrice());
        updateExtensionsModel.getRandomUID();
        updateExtensionsModel.getChefId();
        holder.Price.setText("Price: "+ updateExtensionsModel.getPrice()+"Rs");

    }

    @Override
    public int getItemCount() {
        return updateExtensionsModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView Dishname,Price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.menu_image);
            Dishname = itemView.findViewById(R.id.dishname);
            Price = itemView.findViewById(R.id.dishprice);
        }
    }

}