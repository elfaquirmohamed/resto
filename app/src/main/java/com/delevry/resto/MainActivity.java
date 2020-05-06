package com.delevry.resto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
/*
    RecyclerView mRecyclerView;
List<MenuData>myFoodList;
MenuData mFoodData;
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/* Activity to fragment*/
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,new RestoFragment()).addToBackStack(null).commit();

/*
        mRecyclerView=findViewById(R.id.recycler_menu);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        myFoodList=new ArrayList<>();
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

          MyAdapter myAdapter=new MyAdapter(MainActivity.this,myFoodList);
          mRecyclerView.setAdapter(myAdapter);
 */

        /*fragment bottom style*/
        BottomNavigationView bottomNav = findViewById(R.id.botttom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }
    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment =null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_menu:
                            selectedFragment=new RestoFragment();
                            break;
                        case R.id.nav_favorite:
                            selectedFragment=new FavoriteFragment();
                            break;
                        case R.id.nav_Account:
                            selectedFragment=new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return  true;
                }
            };
}
