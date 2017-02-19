package main.controller;

import main.model.entity.Item;
import main.model.service.item.ItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemTableController {

    @Autowired
    ItemDataService itemDataService;

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String showItemTable(ModelMap model) {
        List<Item> items = itemDataService.findAll();
        model.addAttribute("items", items);
        return "table";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
