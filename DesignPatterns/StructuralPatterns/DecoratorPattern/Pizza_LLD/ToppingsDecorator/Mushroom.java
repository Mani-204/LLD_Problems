package Pizza_LLD.ToppingsDecorator;

import Pizza_LLD.BasePizza;

public class Mushroom extends BasePizza{

    BasePizza basePizza;

    public Mushroom(BasePizza pizza){
        this.basePizza=pizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost() + 18;
    }
}