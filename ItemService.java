package com.containerize.restapidocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.containerize.restapidocker.entity.Item;
import com.containerize.restapidocker.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepo;

	public List<Item> findAllItems() {
			return itemRepo.findAll();
	}

	public Item createItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepo.save(item);
	}

}
