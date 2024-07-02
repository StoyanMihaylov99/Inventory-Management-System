package org.example.restdemo.services.Inter;

import org.example.restdemo.models.dtos.ItemDTO;

import java.util.List;

public interface ItemService {

    int saveItem(ItemDTO itemDTO);

    boolean deleteItem(ItemDTO itemDTO);

    ItemDTO findItemById(int id);

    ItemDTO updateItem(ItemDTO itemDTO);

    List<ItemDTO> findAll();
}
