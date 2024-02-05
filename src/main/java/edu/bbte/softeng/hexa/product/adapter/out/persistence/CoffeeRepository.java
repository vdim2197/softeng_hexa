package edu.bbte.softeng.hexa.product.adapter.out.persistence;

import edu.bbte.softeng.hexa.product.application.domain.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> findAll();
    Coffee save(Coffee coffee);
    Coffee findByNameIgnoreCase(String name);
}
