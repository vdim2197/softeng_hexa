package edu.bbte.softeng.hexa.product.application.domain.service;

import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;
import edu.bbte.softeng.hexa.product.adapter.out.persistence.CoffeeOutputPortImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffees-input")
public class CoffeeService {
    private final CoffeeServiceImpl coffeeService;

    public CoffeeService(CoffeeServiceImpl coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<Coffee> listAllCoffees() {
        return coffeeService.listAllCoffees();
    }

    @PostMapping("/buy")
    public void buyCoffee(@RequestBody Coffee coffee) {
        coffeeService.buyCoffee(coffee);
    }

    @PostMapping("/add")
    public void addCoffee(@RequestBody Coffee coffee) {
        coffeeService.addCoffee(coffee);
    }
}
