package Observers;

import Observable.ItemInStockObservable;

public class EmailAlertObserverImpl implements SpecificAlertObserver{
    private String emailId;
    private ItemInStockObservable observable;

    public EmailAlertObserverImpl(String emailId, ItemInStockObservable observable){
        this.emailId=emailId;
        this.observable=observable;
    }

    @Override
    public void update(){
        sendEmail(emailId, "Item is in stock now, hurry up!!");
    }

    private void sendEmail(String emailId, String msg){
        System.out.println("Email has been sent to: " + emailId);
        //send the actual email to the end user
    }
}
