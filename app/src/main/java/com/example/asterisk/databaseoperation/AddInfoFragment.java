package com.example.asterisk.databaseoperation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInfoFragment extends Fragment {
    EditText name,phone;
    Button save,cancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.adduser,null);
        name = v.findViewById(R.id.name);
        phone = v.findViewById(R.id.phone);
        save = v.findViewById(R.id.save);
        cancel = v.findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frame,new DashFragment()).commit();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info i = new Info();
                i.setName(name.getText().toString());
                i.setPhone(phone.getText().toString());
                MainActivity.myDatabase.dbObj().addInfo(i);
                Toast.makeText(getActivity(),"Data set successfully",Toast.LENGTH_SHORT).show();

                MainActivity.fm.beginTransaction().replace(R.id.frame,new DashFragment()).commit();
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

