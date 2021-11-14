package com.digitalinnovation.one.heroesapi.service;

import com.digitalinnovation.one.heroesapi.model.Hero;
import com.digitalinnovation.one.heroesapi.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    public Flux<Hero> findAll(){
        return Flux.fromIterable(this.heroRepository.findAll());
    }

    public Mono<Hero> findById(String id){
        return Mono.justOrEmpty(this.heroRepository.findById(id));
    }

    public Mono<Hero> save(Hero hero){
        return Mono.justOrEmpty(this.heroRepository.save(hero));
    }

    public Mono<Boolean> deleteHeroById(String id){
        heroRepository.deleteById(id);
        return Mono.just(true);
    }
}
