package com.example.fredd.myparcial.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fredd.myparcial.R;
import com.example.fredd.myparcial.entities.Users;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<Users> usersList;

    public UserAdapter(ArrayList<Users> usersArrayList) {
        this.usersList = usersArrayList;
    }



    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_user,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.test1.setText(usersList.get(position).getUser());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView test1;
        public ViewHolder(View itemView) {
            super(itemView);
            test1 = itemView.findViewById(R.id.test1);
        }
    }
}
