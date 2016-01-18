package cn.uhei.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/1/18.
 */
public class MainActivity extends Activity {

    private ListView listView;
    private ArrayAdapter<ExampleItem> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查找listView
        listView = (ListView) findViewById(R.id.listView);

        //初始化ArrayAdapte
        //arg1 上下文
        //arg2 子元素显示布局样式（调用系统自带的布局）
        adapter = new ArrayAdapter<ExampleItem>(this,android.R.layout.simple_list_item_1);

        //adapter添加内容，并重写ExampleItem的抽象方法，执行另外一个动作
        adapter.add(new ExampleItem("ArrayAdapter示例") {

            //重写onAction方法，执行启动另外一个Activity
            @Override
            public void onAction() {

                //启动另外一个Activity
                startActivity(new Intent(MainActivity.this,ArrayAdapterExampleActivity.class));

            }
        });

        //填充列表
        listView.setAdapter(adapter);

        /**
         * 列表交互
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.getItem(position).onAction();
            }
        });
    }
}
