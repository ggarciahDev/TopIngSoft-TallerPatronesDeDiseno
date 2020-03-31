/*package com.journaldev.dao;

import com.journaldev.model.Books;*/

import java.util.ArrayList;
import java.util.List;

public interface ItemDao {

    public void addItem(Item items);

    public void printItem();

    public void delItem(int idItem);

    public void updateItem(int idItem, Item items);

    public ArrayList<Item> getItems();
}