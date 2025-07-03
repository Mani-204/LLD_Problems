package Observable;

import Observers.SpecificAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneInStockObservableImpl implements ItemInStockObservable{
    private List<SpecificAlertObserver> observerList = new ArrayList<>();
    private int stockCount = 0;

    @Override
    public void add(SpecificAlertObserver observer){
        observerList.add(observer);
    }
    @Override
    public void remove(SpecificAlertObserver observer){
        observerList.remove(observer);
    }
    @Override
    public void notifySubscribers(){
        for(SpecificAlertObserver observer: observerList){
            observer.update();
        }
    }
    @Override
    public void setStockCount(int newStockCount){
        if(stockCount==0){
            notifySubscribers();
        }
        stockCount=newStockCount;
    }
    @Override
    public int getStockCount(){
        return stockCount;
    }

}
