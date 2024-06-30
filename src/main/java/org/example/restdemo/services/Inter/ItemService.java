package org.example.restdemo.services.Inter;

import org.example.restdemo.models.dtos.ItemDTO;

public interface ItemService {

    int saveItem(ItemDTO itemDTO);

    boolean deleteItem(ItemDTO itemDTO);
    ItemDTO findItemById(int id);
    boolean updateItem(ItemDTO itemDTO);
}
