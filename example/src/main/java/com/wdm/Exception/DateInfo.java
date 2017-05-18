package com.wdm.Exception;

import java.util.Date;

public class DateInfo extends Pair<Date> {

    @Override  
    public void setValue(Date value) {  
        super.setValue(value);  
    }
    @Override  
    public Date getValue() {  
        return super.getValue();  
    }


    public static void main(String[] args) throws ClassNotFoundException {
        DateInfo dateInfo = new DateInfo();
        dateInfo.setValue(new Date());
        // dateInfo.setValue(new Object());//编译错误
        Pair<Date> pair = new Pair<>();
        pair.setValue(new Date());
 }  
}
