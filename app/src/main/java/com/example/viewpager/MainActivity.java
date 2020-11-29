package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        List<String> list=new ArrayList<>();//普通页卡
//        for(int i=0;i<3;i++){
//            list.add("第"+i+"个view");
//        }
        List<String>  title=new ArrayList<>();
        title.add("a");
        title.add("b");
        title.add("c");
//        ViewpagerAdapter viewPager=new ViewpagerAdapter(this,list,title);
//        ViewPager viewPager1=(ViewPager)findViewById(R.id.viewPager);
//        viewPager1.setAdapter(viewPager);


                                                                      ///碎片页卡
List<Fragment> listfrag=new ArrayList<>();
listfrag.add(new fragment1());
listfrag.add(new fragment2() );
listfrag.add(new fragment3());
ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
fragpagerAdapter fragpagerAdapter=new fragpagerAdapter(getSupportFragmentManager(),listfrag,title);
viewPager.setAdapter(fragpagerAdapter);
    }
}