package com.containerize.restapidocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.containerize.restapidocker.entity.Item;
import com.containerize.restapidocker.entity.Product;
import com.containerize.restapidocker.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	 @PostMapping
	    public ResponseEntity<Item> createProduct(@RequestBody Item item) {
	        return ResponseEntity.ok(itemService.createItem(item));
	    }

	 @GetMapping("/findAllItems")
	    public ResponseEntity<List<Item>> findAllItems() {
	        return ResponseEntity.ok(itemService.findAllItems());
	    }

}
