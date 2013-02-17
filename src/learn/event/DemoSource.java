package learn.event;

import java.util.ArrayList;

public class DemoSource {
    private ArrayList<DemoListener> list = new ArrayList<DemoListener>();
    public DemoSource(){}

    public void addListener(DemoListener dl){
        list.add(dl);
    }

    public void notifyDemoEvent(){
        for(DemoListener dl: list){
            dl.demoListener(new DemoEvent(this));
        }
    }

}
