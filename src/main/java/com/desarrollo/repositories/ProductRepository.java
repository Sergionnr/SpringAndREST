package com.desarrollo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import com.desarrollo.entities.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
