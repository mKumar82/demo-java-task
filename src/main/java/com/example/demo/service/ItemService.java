package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();


    public Item addItem(Item item) {

        boolean exists = items.stream()
                .anyMatch(i -> i.getId().equals(item.getId()));

        if (exists) {
            throw new RuntimeException(
                    "Item with ID " + item.getId() + " already exists"
            );
        }

        items.add(item);
        return item;
    }


    public Item getItemById(Long id) {

        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}