package edu.bbte.softeng.hexa.product.application.port.out;

import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;

public interface CoffeeOutputPort {
    void saveCoffee(Coffee coffee);
    Coffee getCoffeeByName(String name);
}
