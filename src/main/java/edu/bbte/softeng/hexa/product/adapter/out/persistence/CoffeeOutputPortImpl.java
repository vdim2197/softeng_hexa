package edu.bbte.softeng.hexa.product.adapter.out.persistence;

import edu.bbte.softeng.hexa.product.adapter.out.persistence.CoffeeRepository;
import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;
import edu.bbte.softeng.hexa.product.application.port.out.CoffeeOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CoffeeOutputPortImpl implements CoffeeOutputPort {

    private final CoffeeRepository coffeeRepository;

    public CoffeeOutputPortImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public void saveCoffee(Coffee coffee) {

        log.info("Saving coffee: {}" , coffee.getName());
    }

    @Override
    public Coffee getCoffeeByName(String name) {
        log.info("Retrieving coffee by name: {}", name);
        return coffeeRepository.findByNameIgnoreCase(name);
    }
}
