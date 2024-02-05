package edu.bbte.softeng.hexa.product.adapter.in.web;

import edu.bbte.softeng.hexa.product.adapter.out.persistence.RepositoryException;
import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;
import edu.bbte.softeng.hexa.product.application.domain.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeService coffeeInputPort;

    public CoffeeController(CoffeeService coffeeInputPort) {
        this.coffeeInputPort = coffeeInputPort;
    }

    @GetMapping
    public List<Coffee> listAllCoffees() {
        return coffeeInputPort.listAllCoffees();
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyCoffee(@RequestBody Coffee coffee) {
        try {
            coffeeInputPort.buyCoffee(coffee);
            return ResponseEntity.ok("It was bought successfully.");
        } catch (RepositoryException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error buying coffee: " + e.getMessage());
        }

    }

    @PostMapping("/add")
    public ResponseEntity<String> addCoffee(@RequestBody Coffee coffee) {
        try {
            coffeeInputPort.addCoffee(coffee);
            return ResponseEntity.ok("The coffee was added successfully.");
        } catch (RepositoryException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error buying coffee: " + e.getMessage());
        }

    }
}
