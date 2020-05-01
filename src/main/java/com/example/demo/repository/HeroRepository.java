package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.data.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query("FROM Hero WHERE LOWER(name) LIKE LOWER(:name)")
    List<Hero> findByName(@Param("name") String name);

}
