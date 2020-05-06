package com.delevry.resto;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailResto extends AppCompatActivity {


    RecyclerView mRecyclerView;
    List<MenuData> myFoodList;
    MenuData mFoodData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resto_recycler);


        mRecyclerView=findViewById(R.id.recycler_menu);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(DetailResto.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
   /*     myFoodList=new ArrayList<>();
    mFoodData= new MenuData("test1", "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. ","17 Dhs",R.drawable.imagefood);
        myFoodList.add(mFoodData);

        mFoodData= new MenuData("test2", "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. ","18 Dhs",R.drawable.imagefood);
        myFoodList.add(mFoodData);

        mFoodData= new MenuData("test3", "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. ","20 Dhs",R.drawable.imagefood);
        myFoodList.add(mFoodData);

        mFoodData= new MenuData("test4", "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. ","15 Dhs",R.drawable.imagefood);
        myFoodList.add(mFoodData);

        mFoodData= new MenuData("test5", "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. ","10 Dhs",R.drawable.imagefood);
        myFoodList.add(mFoodData);

        MyAdapter myAdapter=new MyAdapter(DetailResto.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);


    */
    }

    public void btn_uploadeActivity(View view) {

        startActivity(new Intent(this,Upload_Recipe.class));

    }
}
