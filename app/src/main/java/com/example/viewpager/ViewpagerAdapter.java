package com.example.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

public class ViewpagerAdapter extends PagerAdapter {
    private Context mcontext;
    private List<String> mData;
    List<String>  title;

    public  ViewpagerAdapter(Context context,List<String> list,List<String> title){
        mcontext=context;
        mData=list;
        this.title=title;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {//view移除给定位置的view
      container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {//决定一个页面view是否与instantiteItem()
//方法返回的key对象相关联，viewpager不直接处理每一个视图而是将各个视图与一个键联系起来。这个键用来跟踪且唯一代表一个页面
        return view==object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {//创建指定位置的视图
        View view=View.inflate(mcontext,R.layout.page,null);//mcontext用于加载界面
        TextView tv=(TextView)view.findViewById(R.id.text);
        tv.setText(mData.get(position));
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {//获得viewpager有几个view
        return mData.size();
    }
}
