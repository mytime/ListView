package cn.uhei.listview;

/**
 * 自定义列表数据模型.
 */
public class ListCellData {
    private String label;

    //构造函数的主要作用是传递参数
    //1直接使用输出的对象所在内存地址，
    public ListCellData(String label) {
        this.label = label;
    }

    //2把label转成字符串后输出
    @Override
    public String toString() {
        return label;
    }
}
