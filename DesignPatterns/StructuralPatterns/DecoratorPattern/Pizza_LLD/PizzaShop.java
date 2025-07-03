package Pizza_LLD;

import Pizza_LLD.ToppingsDecorator.CheeseBurst;
import Pizza_LLD.ToppingsDecorator.ExtraCheese;

public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza1 = new Margherita();
        BasePizza pizza2 = new CheeseBurst(new Margherita());
        BasePizza pizza3 = new ExtraCheese(new CheeseBurst(new Margherita()));

        System.out.println("Cost of pizza1 : " + pizza1.cost());
        System.out.println("Cost of pizza2 : " + pizza2.cost());
        System.out.println("Cost of pizza3 : " + pizza3.cost());
    }
}
