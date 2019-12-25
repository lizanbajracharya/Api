package com.example.api.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api.DashActivity;
import com.example.api.R;
import com.example.api.RegisterActivity;
import com.example.api.URL.URL;
import com.example.api.api.EmployeeAPI;
import com.example.api.model.EmployeeCUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    private EditText etName,etSalary,etAge;
    private Button btnSave;

    private void Register(){
        String name=etName.getText().toString();
        Float salary=Float.parseFloat(etSalary.getText().toString());
        Integer age=Integer.parseInt(etAge.getText().toString());

        EmployeeCUD employeeCUD=new EmployeeCUD(name,salary,age);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(URL.base_url).addConverterFactory(GsonConverterFactory.create()).build();

        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);

        Call<Void> voidCall=employeeAPI.registerEmployee(employeeCUD);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getContext(), "You have been successfully registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete, container, false);
        etAge=view.findViewById(R.id.etAge);
        etName=view.findViewById(R.id.etName);
        etSalary=view.findViewById(R.id.etSalary);
        btnSave=view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        return view;
    }

}
