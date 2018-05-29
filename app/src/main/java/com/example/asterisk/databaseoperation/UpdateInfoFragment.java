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

public class UpdateInfoFragment extends Fragment {
    EditText id, name, phone;
    Button updateBtn,cancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        updateBtn = view.findViewById(R.id.update);
        cancel = view.findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frame, new DashFragment()).commit();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info info = new Info();
                info.setName(name.getText().toString());
                info.setPhone(phone.getText().toString());
                info.setId(Integer.parseInt(id.getText().toString()));

                MainActivity.myDatabase.dbObj().updateInfo(info);
                Toast.makeText(getActivity(), "Data updated.", Toast.LENGTH_SHORT).show();
                MainActivity.fm.beginTransaction().replace(R.id.frame, new DashFragment()).commit();
            }
        });
    }
}
