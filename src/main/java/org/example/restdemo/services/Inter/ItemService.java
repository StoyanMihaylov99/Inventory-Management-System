package org.example.restdemo.services.Inter;

import org.example.restdemo.models.dtos.ItemDTO;

public interface ItemService {

    void saveItem(ItemDTO itemDTO);

    void deleteItem(ItemDTO itemDTO);
    ItemDTO findItemById(String id);
    void updateItem(ItemDTO itemDTO);
}
