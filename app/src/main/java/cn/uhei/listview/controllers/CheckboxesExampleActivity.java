package cn.uhei.listview.controllers;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import cn.uhei.listview.R;
import cn.uhei.listview.models.CheckBoxItem;

/**
 * 多项选择列表
 * 继承ListActivity
 */
public class CheckboxesExampleActivity extends ListActivity {

    //
    private ArrayAdapter<CheckBoxItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化
        adapter = new ArrayAdapter<CheckBoxItem>(this,android.R.layout.simple_list_item_multiple_choice){
            //同步列表状态
            //只要有新的列表子项产生，系统就会执行getView方法
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //
                CheckedTextView ctv = (CheckedTextView)  super.getView(position, convertView, parent);

                CheckBoxItem item = getItem(position);
                ctv.setChecked(item.isChecked());

                System.out.println(">>>>>>>>>>>>");
                return ctv;
            }
        };

        //填充
        setListAdapter(adapter);

        //
//        adapter.add("hello");
//        adapter.add("world");
        for (int i = 0; i < 100 ; i++) {
            adapter.add(new CheckBoxItem("Item"+i,false));
        }
    }

    //复选框点击事件
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        CheckBoxItem item = adapter.getItem(position);
        //取反
        item.setChecked(!item.isChecked());

        //刷新列表
        adapter.notifyDataSetChanged();
    }
}
