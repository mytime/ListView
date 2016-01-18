package cn.uhei.listview.models;

/**
 * 数据模型：ListActivity
 */
public abstract class ExampleItem {

    private String label;

    public ExampleItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    //抽象方法
    public abstract void onAction();

    @Override
    public String toString() {
        return  label ;
    }
}
