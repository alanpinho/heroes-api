package com.digitalinnovation.one.heroesapi.repository;

import com.digitalinnovation.one.heroesapi.model.Hero;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroRepository extends CrudRepository<Hero, String> {
}
