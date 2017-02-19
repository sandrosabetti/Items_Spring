package main.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name = "items")
@NamedQuery(name = "Item.getAll", query = "SELECT i from Item i")
@JsonPropertyOrder({"id", "name", "value"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "name", length = 64)
    private String name;

    @JsonIgnore
    @Column(name = "value")
    private long value;

    public Item() {
    }

    public Item(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ("Name   " + name + "\nValue " + value);
    }

}