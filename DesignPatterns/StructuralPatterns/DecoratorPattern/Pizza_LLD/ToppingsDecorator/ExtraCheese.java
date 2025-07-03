package Pizza_LLD.ToppingsDecorator;

import Pizza_LLD.BasePizza;

public class ExtraCheese extends BasePizza {

    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza){
        this.basePizza=pizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost() + 10;
    }
}
