package cn.uhei.listview.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.uhei.listview.R;
import cn.uhei.listview.models.Student;

public class ArrayAdapterExampleActivity extends AppCompatActivity {

    private ListView listView;
    //2字符串类型的adapter
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3初始化adapter
        //arg1 上下文，
        // arg2 每一行的布局样式(可以使用系统自带的)，
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //添加数据
        adapter.add(new Student("zhangsan ", 18));
        adapter.add(new Student("lisi ", 19));
        adapter.add(new Student("lili ", 20));


        listView = (ListView) findViewById(R.id.listView);
        //1列表需要adapter来填充值
        listView.setAdapter(adapter);

        /**
         * 与列表交互
         * 点击列表弹出对话框并展示详细信息
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //获取被点击的子项目
                Student item = adapter.getItem(position);

                //弹出对话框
                new AlertDialog.Builder(ArrayAdapterExampleActivity.this)
                        .setTitle("详细信息")
                        .setMessage("名字" + item.getName() + "年龄" + item.getAge())
                        .setPositiveButton("关闭", null)
                        .show();

            }
        });


        /**
         * 与列表交互
         * 长按列表子项弹出对话框并删除子项
         */

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                //弹出对话框
                new AlertDialog.Builder(ArrayAdapterExampleActivity.this)
                        .setTitle("提示")
                        .setMessage("确定删除")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //删除被点击那个项目的id
                                adapter.remove(adapter.getItem(position));
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                //启用
                return true;
            }
        });
    }
}
