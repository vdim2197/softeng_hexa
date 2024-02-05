package edu.bbte.softeng.hexa.product.application.domain.service;

import edu.bbte.softeng.hexa.product.adapter.out.persistence.CoffeeRepository;
import edu.bbte.softeng.hexa.product.adapter.out.persistence.RepositoryException;
import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;
import edu.bbte.softeng.hexa.product.application.port.in.InPortCoffeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CoffeeServiceImpl implements InPortCoffeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> listAllCoffees() {
        return coffeeRepository.findAll();
    }

    @Override
    public void buyCoffee(Coffee coffee) {
        Coffee existingCoffee = getCoffeeByName(coffee.getName());
        if (existingCoffee != null) {
            if(existingCoffee.getQuantity() >= coffee.getQuantity()) {
                existingCoffee.setQuantity(existingCoffee.getQuantity() - coffee.getQuantity());
                coffeeRepository.save(existingCoffee);
            } else {
                log.error("There isn't enough quantity");
                throw new RepositoryException("There isn't enough quantity");
            }

        } else {
            log.error("It doesn't exists a coffee with the name of " + coffee.getName());
            throw new RepositoryException("It doesn't exists a coffee with the name of " + coffee.getName());
        }
    }

    @Override
    public void addCoffee(Coffee coffee) {
        Coffee existingCoffee = getCoffeeByName(coffee.getName());
        if (existingCoffee != null) {
            existingCoffee.setQuantity(existingCoffee.getQuantity() + coffee.getQuantity());
            coffeeRepository.save(existingCoffee);
        } else {
            coffeeRepository.save(coffee);
        }
    }

    private Coffee getCoffeeByName(String coffeeName) {
        return coffeeRepository.findByNameIgnoreCase(coffeeName);
    }



}
