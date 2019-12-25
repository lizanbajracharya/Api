package com.example.api.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api.R;
import com.example.api.SearchActivity;
import com.example.api.URL.URL;
import com.example.api.api.EmployeeAPI;
import com.example.api.model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private EditText etEmpNo;
    private TextView tvData;
    private Button btnSearch;
    private void loadData(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(URL.base_url).addConverterFactory(GsonConverterFactory.create()).build();
        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);

        Call<Employee> listCall=employeeAPI.getEmployeeByID(Integer.parseInt(etEmpNo.getText().toString()));
        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                String content="";
                content+="Id : "+response.body().getId() +"\n";
                content+="Name : "+response.body().getEmployee_name() +"\n";
                content+="Age : "+response.body().getEmployee_age() +"\n";
                content+="Salary : "+response.body().getEmployee_salary() +"\n";

                tvData.setText(content);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search2, container, false);
        etEmpNo=view.findViewById(R.id.etFirst);
        tvData=view.findViewById(R.id.tvData);
        btnSearch=view.findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        return view;
    }

}
