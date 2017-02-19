package main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.entity.Item;
import main.model.service.item.ItemDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ItemRestController {

    private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);

    @Autowired
    ItemDataService itemDataService;

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> getAllItems() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(itemDataService.findAll()));
        return itemDataService.findAll();
    }

    @RequestMapping(value = "/items", method = RequestMethod.PUT)
    public void updateItem(@RequestBody Item item) {
        itemDataService.editItem(item);
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        return itemDataService.addItem(item);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable(value = "id") long id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(itemDataService.getOne(id)));
        return itemDataService.getOne(id);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable(value = "id") long id) {
        itemDataService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
        logger.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
