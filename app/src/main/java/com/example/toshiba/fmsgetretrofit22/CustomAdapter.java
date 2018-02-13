package com.example.toshiba.fmsgetretrofit22;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.toshiba.fmsgetretrofit22.model.Result;
import com.example.toshiba.fmsgetretrofit22.model.User;

import java.util.List;

/**
 * Created by TOSHIBA on 12/02/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    List<Result> results;

    public CustomAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.value_row, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Result result = results.get(position);
        holder.id.setText(result.get_id());
        holder.nama.setText(result.getNama());
        holder.email.setText(result.getEmail());
        holder.alamat.setText(result.getAlamat());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,nama,email,alamat;

        public ViewHolder(View itemView) {
            super(itemView);
            id =  itemView.findViewById(R.id.tid);
            nama = itemView.findViewById(R.id.tnama);
            email =  itemView.findViewById(R.id.temail);
            alamat = itemView.findViewById(R.id.talamat);


        }
    }
}
