package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.data.Hero;
import com.example.demo.repository.HeroRepository;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Transactional(readOnly = true)
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Hero find(Integer id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Hero> findByName(String name) {
        return heroRepository.findByName("%" + name + "%");
    }

    @Transactional(readOnly = true)
    public Optional<Hero> findById(Integer id) {
        return heroRepository.findById(id);
    }

    @Transactional
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Transactional
    public void delete(Hero hero) {
        heroRepository.delete(hero);
    }

    @Transactional
    public void delete(Integer id) {
        heroRepository.deleteById(id);
    }

}
