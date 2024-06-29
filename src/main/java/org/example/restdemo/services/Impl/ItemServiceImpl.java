package org.example.restdemo.services.Impl;

import org.example.restdemo.models.dtos.ItemDTO;
import org.example.restdemo.services.Inter.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {


    @Override
    public void saveItem(ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(ItemDTO itemDTO) {

    }

    @Override
    public ItemDTO findItemById(String id) {
        return null;
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {

    }
}
