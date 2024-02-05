package edu.bbte.softeng.hexa.product.application.port.in;

import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;

import java.util.List;

public interface InPortCoffeService {

    List<Coffee> listAllCoffees();
    void buyCoffee(Coffee coffeeName);
    void addCoffee(Coffee coffeeName);
}
