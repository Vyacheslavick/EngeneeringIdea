package com.example.slavick.engeneeringidea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>{
    public UsersRecyclerAdapter(Context context, List<User> userList, OnRecyclerItemClick onRecyclerItemClick) {
        this.context = context;
        this.userList = userList;
        this.onRecyclerItemClick = onRecyclerItemClick;
    }

    private Context context;
    private List<User> userList;
    private OnRecyclerItemClick onRecyclerItemClick;

    @NonNull
    @Override
    public UsersRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersRecyclerAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.email.setText(user.email);
        holder.name.setText(user.name);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    interface OnRecyclerItemClick {
        void onClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecyclerItemClick.onClick(getAdapterPosition());
                }
            });
        }
    }
}
