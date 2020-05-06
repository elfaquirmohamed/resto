package com.delevry.resto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RestoFragment extends Fragment {

RecyclerView rRecyclerView;
List<RestoData> rRestoList;

public RestoFragment(){

}

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_resto,container,false);

        rRecyclerView = view.findViewById(R.id.recycler_resto);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

  //initData();
           rRecyclerView.setAdapter(new RestoAdapter(initData()));


        return view;

    }

    private List<RestoData> initData(){
        rRestoList=new ArrayList<>();
        rRestoList.add(new RestoData(R.drawable.kfc,"KFC","Fastfood","5","agadir"));
        rRestoList.add(new RestoData(R.drawable.kfc,"KFC","Fastfood","2","casablanca"));
        rRestoList.add(new RestoData(R.drawable.kfc,"KFC","Fastfood","3","Tanger"));
        rRestoList.add(new RestoData(R.drawable.kfc,"KFC","Fastfood","1","Maraackech"));
        return rRestoList;
    }
}
