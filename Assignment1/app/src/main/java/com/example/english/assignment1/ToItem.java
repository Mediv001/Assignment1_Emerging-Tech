package com.example.english.assignment1;

/**
 * Created by english on 09/03/2016.
 */
public class ToItem {

    boolean checked;
    String data;

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isChecked() {
        return checked;
    }

    public ToItem(boolean checked, String dat){
        data = dat;
        this.checked = checked;
    }
}
