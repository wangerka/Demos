package com.example.fragmenttabhostdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fragmenttabhostdemo.bean.Tab;
import com.example.fragmenttabhostdemo.fragment.HomeFragment;
import com.example.fragmenttabhostdemo.fragment.SettingsFragment;
import com.example.fragmenttabhostdemo.fragment.TodayFragment;
import com.example.fragmenttabhostdemo.fragment.TomorrowFragment;


public class MainActivity extends ActionBarActivity {
	
	private FragmentTabHost tabHost ;
	private LayoutInflater inflat;
	private List<Tab> list = new ArrayList<Tab>(4);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inflat = LayoutInflater.from(this);
        
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        
        
        /*
         * 
         * 将会变化的元素封装成一个类，将每一组变化元素按照一个类new出来。通过get方法获取变化元素
         * 
         * 
         * 图片的selector放在drawable里
         * 
         * 文字颜色的selector放在color里面
         */
        Tab home = new Tab(R.drawable.home_selector,R.string.home, HomeFragment.class);
        Tab today = new Tab(R.drawable.today_selector, R.string.today,TodayFragment.class);
        Tab tomorrow = new Tab(R.drawable.tomorrow_selector, R.string.tomorrow,TomorrowFragment.class);
        Tab setting = new Tab(R.drawable.setting_selector, R.string.setting,SettingsFragment.class);
        
        list.add(home);
        list.add(today);
        list.add(tomorrow);
        list.add(setting);
        
        for (Tab tab : list) {
        	
        	View view= inflat.inflate(R.layout.indicator, null);
            ImageView iamge = (ImageView) view.findViewById(R.id.image);
            iamge.setBackgroundResource(tab.getImage());
            tabHost.addTab(tabHost.newTabSpec(getString(tab.getTag())).setIndicator(view), tab.getFragment(), null);
		}
        
        
        tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabHost.setCurrentTab(0);
    }
    
}
