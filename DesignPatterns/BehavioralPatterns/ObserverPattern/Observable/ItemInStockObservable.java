package Observable;

import Observers.SpecificAlertObserver;

public interface ItemInStockObservable {
    void add(SpecificAlertObserver observer);
    void remove(SpecificAlertObserver observer);
    void notifySubscribers();
    void setStockCount(int newStockCount);
    int getStockCount();
}
