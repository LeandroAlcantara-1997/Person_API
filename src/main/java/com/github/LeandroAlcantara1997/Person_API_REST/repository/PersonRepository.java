package com.github.LeandroAlcantara1997.Person_API_REST.repository;

import com.github.LeandroAlcantara1997.Person_API_REST.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
