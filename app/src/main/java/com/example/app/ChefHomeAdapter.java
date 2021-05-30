package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChefHomeAdapter extends RecyclerView.Adapter<ChefHomeAdapter.ViewHolder> {

    private Context mcont;
    private List<UpdateExtensionsModel> updateExtensionsModelList;

    public ChefHomeAdapter(Context context , List<UpdateExtensionsModel> updateExtensionsModelList){
        this.updateExtensionsModelList = updateExtensionsModelList;
        this.mcont = context;
    }

    @NonNull
    @Override
    public ChefHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcont).inflate(R.layout.chefmenu_update_delete,parent,false);
        return new ChefHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChefHomeAdapter.ViewHolder holder, int position) {

        final UpdateExtensionsModel updateExtensionsModel = updateExtensionsModelList.get(position);
        holder.dishes.setText(updateExtensionsModel.getDishes());
        updateExtensionsModel.getRandomUID();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcont,UpdateDelete_Dish.class);
                intent.putExtra("updatedeletedish", updateExtensionsModel.getRandomUID());
                mcont.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return updateExtensionsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishes = itemView.findViewById(R.id.dish_name);
        }
    }
}