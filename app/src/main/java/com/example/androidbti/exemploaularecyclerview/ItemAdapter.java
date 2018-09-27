package com.example.androidbti.exemploaularecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Item> itemList = new ArrayList<>();

    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;

        for (int i = 0; i < 100; i++) {
            itemList.add(new Item(i+1, "Item " + (i+1)));
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, viewGroup, false);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Item item = itemList.get(i);
        itemHolder.txtNOME.setText(item.getNome());
        itemHolder.txtID.setText(String.valueOf(item.getId()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtID;
        public TextView txtNOME;

        public ItemHolder(@NonNull View itemView) {

            super(itemView);
            txtID = itemView.findViewById(android.R.id.text1);
            txtNOME = itemView.findViewById(android.R.id.text2);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            itemList.remove(pos);
            Toast.makeText(context, "Item Removido " + pos, Toast.LENGTH_SHORT).show();
            notifyItemRemoved(pos);
        }
    }


}
