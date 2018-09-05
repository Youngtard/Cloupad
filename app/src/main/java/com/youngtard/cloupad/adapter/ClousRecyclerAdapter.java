package com.youngtard.cloupad.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youngtard.cloupad.R;
import com.youngtard.cloupad.room.Clou;

import java.util.ArrayList;
import java.util.List;


public class ClousRecyclerAdapter extends RecyclerView.Adapter<ClousRecyclerAdapter.ClousViewHolder> {
    private List<Clou> clous;
    private Context context;


    public ClousRecyclerAdapter(ArrayList<Clou> clous , Context context) {
        this.clous = clous;
        this.context = context;

    }

    @NonNull
    @Override
    public ClousViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.entry_list_item, parent, false);

        return new ClousViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClousViewHolder holder, int position) {
        holder.bind(clous.get(position));
    }

    @Override
    public int getItemCount() {
        return clous.size();
    }


    //Sets clous to recycler list view
    public void setClous(List<Clou> clous) {
//        clous.clear();
        this.clous = clous;
        notifyDataSetChanged();
    }

    class ClousViewHolder extends RecyclerView.ViewHolder {
        TextView clouTitle;
        TextView clouContent;
//        TextView/Date

        public ClousViewHolder(View itemView){
            super(itemView);

            clouTitle = itemView.findViewById(R.id.tv_clou_title);
            clouContent = itemView.findViewById(R.id.tv_clou_content);

        }

        void bind(Clou clou){
//            clouTitle.setText(clou.getClouTitle());
//            clouContent.setText(clou.getClouContent());
            clouTitle.setText(clou.getClouTitle());
            clouContent.setText(clou.getClouContent());
        }
    }
}
