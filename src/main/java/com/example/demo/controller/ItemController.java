package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;


    @PostMapping
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
        try {
            Item saved = service.addItem(item);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saved);

        } catch (RuntimeException ex) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(error(ex.getMessage()));

        } catch (Exception ex) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error(ex.getMessage()));
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        try {
            Item item = service.getItemById(id);

            if (item == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(error("Item not found"));
            }

            return ResponseEntity.ok(item);

        } catch (Exception ex) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error(ex.getMessage()));
        }
    }


    private Map<String, String> error(String msg) {
        Map<String, String> error = new HashMap<>();
        error.put("error", msg);
        return error;
    }
}