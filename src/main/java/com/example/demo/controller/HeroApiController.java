package com.example.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.data.Hero;
import com.example.demo.service.HeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/heroes")
public class HeroApiController {

    private static final Logger log = LoggerFactory.getLogger(HeroApiController.class);

    @Autowired
    private HeroService heroService;

    @GetMapping
    public List<Hero> getAll() {
        return heroService.findAll();
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable Integer id, HttpServletResponse resp) {
        log.debug("getHero id={}", id);
        Hero hero = heroService.find(id);
        if (hero == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return hero;
    }

    @GetMapping("/")
    public List<Hero> search(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "id", required = false) Integer id) {
        log.debug("search name={}, id={}", name, id);
        if (name != null) {
            return heroService.findByName(name);
        } else if (id != null) {
            return heroService.findById(id).map(Arrays::asList).orElse(Collections.emptyList());
        }
        return heroService.findAll();
    }

    @PostMapping
    public Hero insert(@RequestBody Hero hero) {
        log.debug("insert {}", hero);
        Hero saved = heroService.save(hero);
        log.debug("inserted {}", hero);
        return saved;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.debug("delete id={}", id);
        heroService.delete(id);
    }

    @PutMapping
    public Hero update(@RequestBody Hero hero) {
        log.debug("update {}", hero);
        return heroService.save(hero);
    }

}
