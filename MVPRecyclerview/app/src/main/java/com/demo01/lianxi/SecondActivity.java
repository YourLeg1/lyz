package com.demo01.lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bwie.mycartutils.bean.ChildBean;
import com.bwie.mycartutils.bean.GroupBean;
import com.bwie.mycartutils.utils.CartUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ExpandableListView exp;
    private CheckBox cb;
    private TextView text1,text2;

    private List<GroupBean> group;
    private List<List<ChildBean>> child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        exp = (ExpandableListView) findViewById(R.id.exp);
        cb = (CheckBox)findViewById(R.id.cb);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        group = new ArrayList<GroupBean>();
        child = new ArrayList<List<ChildBean>>();


        for (int i = 0; i< 2; i++){

            group.add(new GroupBean("商铺",false));
            List<ChildBean> chilDb = new ArrayList<>();
            for (int j = 0; j< 2; j++){

                chilDb.add(new ChildBean("商品","100","http://avatar.csdn.net/E/B/A/1_liu461211527.jpg ",false,1));
            }
            child.add(chilDb);
        }
        CartUtils.setCartData(this,group,child, exp,cb,text1,text2);



    }
}
