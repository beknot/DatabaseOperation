package com.example.asterisk.databaseoperation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReadInfoFragment extends Fragment {
    TextView data;
    Button back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewuser,null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = view.findViewById(R.id.data);
        back = view.findViewById(R.id.back);
        List<Info> mylist = new ArrayList<>();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frame,new DashFragment()).commit();
            }
        });

        mylist = MainActivity.myDatabase.dbObj().readInfo();

        String mydata = "";
        for (int i = 0; i < mylist.size(); i++) {
            mydata = mydata + mylist.get(i).getId() + "\n"+
                    mylist.get(i).getName() + "\n" + mylist.get(i).getPhone() + "\n\n";

        }
        data.setText(mydata);
    }
}
