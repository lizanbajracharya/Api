package com.example.api.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.R;
import com.example.api.URL.URL;
import com.example.api.api.EmployeeAPI;
import com.example.api.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ContactViewHolder> {
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl(URL.base_url).addConverterFactory(GsonConverterFactory.create()).build();
    EmployeeAPI employeeAPI= retrofit.create(EmployeeAPI.class);
    Call<List<Employee>> listCall=employeeAPI.getAllEmployees();

    public DisplayAdapter(Call<List<Employee>> listCall) {
        this.listCall = listCall;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final Employee employee=listCall.get(position);
    }

    @Override
    public int getItemCount() {
        return ;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tvOutput;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOutput=itemView.findViewById(R.id.tvOutput);
        }
    }
}
