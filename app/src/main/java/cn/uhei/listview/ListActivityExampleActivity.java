package cn.uhei.listview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * 使用listActivity
 */
public class ListActivityExampleActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设定自定义布局
        setContentView(R.layout.list_activity_example);

        //初始化ArrayAdapter
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        //填充list
        setListAdapter(adapter);

        //添加项目元素
        adapter.add("Hello");
        adapter.add("World");
    }
}
