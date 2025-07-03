package Observers;

import Observable.ItemInStockObservable;

public class MessageAlertObserverImpl implements SpecificAlertObserver{
    private String emailId;
    private ItemInStockObservable observable;

    public MessageAlertObserverImpl(String emailId, ItemInStockObservable observable){
        this.emailId=emailId;
        this.observable=observable;
    }

    @Override
    public void update(){
        sendMsg(emailId, "Item is in stock now, hurry up!!");
    }

    private void sendMsg(String emailId, String msg){
        System.out.println("Message has been sent to: " + emailId);
        //send the actual email to the end user
    }
}
