import Observable.IphoneInStockObservableImpl;
import Observable.ItemInStockObservable;
import Observers.EmailAlertObserverImpl;
import Observers.MessageAlertObserverImpl;
import Observers.SpecificAlertObserver;

public class Store {
    public static void main(String[] args) {
        ItemInStockObservable iphoneStockObservable = new IphoneInStockObservableImpl();

        SpecificAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        SpecificAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        SpecificAlertObserver observer = new MessageAlertObserverImpl("xyz@gmail.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer2);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(20);
    }
}
