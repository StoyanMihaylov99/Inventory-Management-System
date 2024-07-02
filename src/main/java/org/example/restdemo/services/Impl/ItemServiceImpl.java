package org.example.restdemo.services.Impl;

import org.example.restdemo.models.dtos.ItemDTO;
import org.example.restdemo.models.entities.Item;
import org.example.restdemo.repositories.ItemRepository;
import org.example.restdemo.services.Inter.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ModelMapper modelMapper, ItemRepository itemRepository) {
        this.modelMapper = modelMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public int saveItem(ItemDTO itemDTO) {
        return itemRepository.save(modelMapper.map(itemDTO, Item.class)).getId();
    }

    @Override
    public boolean deleteItem(ItemDTO itemDTO) {
        if (itemRepository.findById(itemDTO.getId()).isPresent()) {
            itemRepository.delete(modelMapper.map(itemDTO, Item.class));
            return true;
        }
        return false;
    }

    @Override
    public ItemDTO findItemById(int id) {
        Optional<Item> itemToFind = itemRepository.findById(id);
        if (itemToFind.isPresent()) {
            return modelMapper.map(itemToFind, ItemDTO.class);
        }
        return null;
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        Optional<Item> existingItem = itemRepository.findById(itemDTO.getId());
        if (existingItem.isPresent()) {
            Item itemToSave = existingItem.get();
            modelMapper.map(itemDTO, itemToSave);
            itemRepository.save(itemToSave);
            return modelMapper.map(itemRepository.findById(itemToSave.getId()), ItemDTO.class);
        }
        return null;

    }

    @Override
    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream().map(i -> modelMapper.map(i, ItemDTO.class)).collect(Collectors.toList());
    }
}
