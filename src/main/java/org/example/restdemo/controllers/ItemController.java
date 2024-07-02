package org.example.restdemo.controllers;
import org.example.restdemo.models.dtos.ItemDTO;
import org.example.restdemo.services.Impl.ItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemServiceImpl itemService;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable("id") int id) {
        ItemDTO searchedItem = itemService.findItemById(id);
        if (searchedItem == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(searchedItem);
    }

    @PostMapping("/")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO postItem, UriComponentsBuilder uriComponentsBuilder) {
        int itemId = itemService.saveItem(postItem);
        URI location = uriComponentsBuilder.path("/items/{id}").buildAndExpand(itemId).toUri();
        return ResponseEntity.created(location).build();


    }

    @DeleteMapping("/")
    public ResponseEntity<ItemDTO> deleteItem(@RequestBody ItemDTO itemDTO) {
        if (itemService.deleteItem(itemDTO)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        if (itemService.updateItem(itemDTO) != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getAll")
    public List<ItemDTO> getAllItems(){
        return itemService.findAll();
    }
}
