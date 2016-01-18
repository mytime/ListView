package cn.uhei.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    //2字符串类型的adapter
    private ArrayAdapter<ListCellData> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3初始化adapter
        //arg 上下文，每一行的布局样式(可以使用系统自带的)，
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        //添加数据
        adapter.add(new ListCellData("niupeiwang "));
        adapter.add(new ListCellData("hello "));
        adapter.add(new ListCellData("android "));


        listView = (ListView) findViewById(R.id.listView);
        //1列表需要adapter来填充值
        listView.setAdapter(adapter);

    }
}
