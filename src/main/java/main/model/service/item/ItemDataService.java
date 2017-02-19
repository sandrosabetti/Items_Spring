package main.model.service.item;

import main.model.entity.Item;

import java.util.List;

public interface ItemDataService {

    Item addItem(Item item);

    void delete(long id);

    Item findByName(String name);

    Item editItem(Item item);

    Item getOne(long id);

    List<Item> findAll();

}