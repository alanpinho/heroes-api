package com.digitalinnovation.one.heroesapi.controller;

import com.digitalinnovation.one.heroesapi.model.Hero;
import com.digitalinnovation.one.heroesapi.repository.HeroRepository;
import com.digitalinnovation.one.heroesapi.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovation.one.heroesapi.constants.HeroesConstant.ENDPOINT_HEROES_LOCAL;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final HeroRepository heroRepository;

    @GetMapping(ENDPOINT_HEROES_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Hero> findAllHeroes(){
        log.info("Requesting the list of all heroes (is Justice League coming?)");
        return heroService.findAll();
    }

    @GetMapping(ENDPOINT_HEROES_LOCAL+"/id")
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Hero not found")
    public Mono<Hero> findHeroById(@PathVariable String id){
        log.info("Requesting hero with id {}", id);
        return heroService.findById(id);
    }

    @PostMapping(ENDPOINT_HEROES_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Hero> createHero(@RequestBody Hero hero){
        log.info("Congratulations! You created a new hero!");
        return heroService.save(hero);
    }

    @DeleteMapping(ENDPOINT_HEROES_LOCAL+"/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHeroById(@PathVariable String id){
        heroService.deleteHeroById(id);
        log.info("The hero with id {} has been removed", id);
    }
}
