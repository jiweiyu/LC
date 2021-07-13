package Practice;

import org.springframework.beans.factory.DisposableBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloWorld implements DisposableBean {

    private int val;
    private String str;
    private String creatTime;

    public HelloWorld() {
        this.val = 0;
        this.str = "Hello";
        this.creatTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public HelloWorld(int val, String str) {
        this.val = val;
        this.str = str;
    }

    public void init(){
        System.out.println("Bean is going through init.");
    }

    public void destroy() {
        System.out.println("Bean will destroy now.");
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "val=" + val +
                ", str='" + str + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
