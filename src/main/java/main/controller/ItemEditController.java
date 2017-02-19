package main.controller;

import main.model.entity.Item;
import main.model.service.item.ItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemEditController {

    @Autowired
    ItemDataService itemDataService;

    @RequestMapping(value = "/show_item", method = RequestMethod.GET)
    public String showItem(@RequestParam(value = "id") long id, ModelMap model) {
        model.addAttribute("command");
        Item item = itemDataService.getOne(id);
        model.addAttribute("item", item);
        return "show_item";
    }

    @RequestMapping(value = "/edit_item", method = RequestMethod.GET)
    public String editItem(@RequestParam(value = "id") long id, ModelMap model) {
        Item item = itemDataService.getOne(id);
        model.addAttribute("item", item);
        return "edit_item";
    }

    @RequestMapping(value = "/edit_item", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("item") Item item) {
        itemDataService.editItem(item);
        return "redirect:/table";
    }

    @RequestMapping(value = "/delete_item", method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id") long id) {
        itemDataService.delete(id);
        return "redirect:/table";
    }

    @RequestMapping(value = "/add_item", method = RequestMethod.GET)
    public String addItem(ModelMap model) {
        model.addAttribute("item", new Item());
        return "add_item";
    }

    @RequestMapping(value = "/add_item", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("item") Item item) {
        itemDataService.editItem(item);
        return "redirect:/table";
    }

    @RequestMapping(value = "/find_item", method = RequestMethod.GET)
    public String findItem(@ModelAttribute("name") String name, ModelMap model) {
        System.out.print(name);
        Item item = itemDataService.findByName(name);
        model.addAttribute("item", item);
        return "show_item";
    }

}
