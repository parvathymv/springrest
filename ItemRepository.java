package com.containerize.restapidocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.containerize.restapidocker.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();

    List<Item> findByName(@Param("name") String name);

    Item findByPrice(@Param("price") Double price);

}

