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

public class DeleteInfoFragment extends Fragment {
    EditText id;
    Button delete,cancel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id = view.findViewById(R.id.id);
        delete = view.findViewById(R.id.delete);
        cancel = view.findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frame,new DashFragment()).commit();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info i = new Info();
                i.setId(Integer.parseInt(id.getText().toString()));
                MainActivity.myDatabase.dbObj().deleteData(i);
                Toast.makeText(getActivity(), "Data deleted.", Toast.LENGTH_SHORT).show();
                MainActivity.fm.beginTransaction().replace(R.id.frame, new DashFragment()).commit();

            }
        });

    }
}