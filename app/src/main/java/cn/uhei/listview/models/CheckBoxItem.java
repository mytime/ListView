package cn.uhei.listview.models;

/**
 * 复选框模型
 */
public class CheckBoxItem {
    private String label;
    private boolean checked = false;

    //构造，传递参数
    public CheckBoxItem(String label, boolean checked) {
        this.label = label;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
