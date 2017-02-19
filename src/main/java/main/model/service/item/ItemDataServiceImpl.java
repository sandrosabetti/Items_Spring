package main.model.service.item;

import main.model.entity.Item;
import main.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDataServiceImpl implements ItemDataService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @Override
    public void delete(long id) {
        itemRepository.delete(id);
    }

    @Override
    public Item getOne(long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Item editItem(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

}
