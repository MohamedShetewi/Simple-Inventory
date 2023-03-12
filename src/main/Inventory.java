package main;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemsList;
    private long idTrack;

    public Inventory() {
        this.itemsList = new ArrayList<>();
        this.idTrack = 0;
    }

    public void addItem(String name, String description, int quantity) throws InventoryException {
        if (quantity < 0)
            throw new InventoryException("Negative quantity: Cannot enter item with negative quantity");
        idTrack++;
        Item newItem = new Item(idTrack + "", name, description, quantity);
        itemsList.add(newItem);
    }

    public void removeItem(String id) {

    }

    public void updateItem(String itemId, String name, String description, int quantity) {

    }

    public Item getItem(String id) {
        return null;
    }

    public ArrayList<Item> getInventory() {
        return itemsList;
    }
}
