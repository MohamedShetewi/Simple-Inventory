package Inventory;

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

    public void removeItem(String id) throws InventoryException {
        int index = SearchItems.searchForItemIndex(id, itemsList);
        if (index == -1)
            throw new InventoryException("Unavailable item: Cannot find an item with the provided id = " + id);
        itemsList.remove(index);
    }

    public void updateItem(String itemId, String name, String description, int quantity) throws InventoryException {
        int index = SearchItems.searchForItemIndex(itemId, itemsList);
        if (index == -1)
            throw new InventoryException("Unavailable item: Cannot find an item with the provided id = " + itemId);
        if (quantity < 0)
            throw new InventoryException("Negative quantity: Cannot enter item with negative quantity");

        Item itemToBeUpdated = itemsList.get(index);
        itemToBeUpdated.setName(name);
        itemToBeUpdated.setDescription(description);
        itemToBeUpdated.setQuantity(quantity);
    }

    public Item getItem(String id) throws InventoryException {
        int index = SearchItems.searchForItemIndex(id, itemsList);
        if (index == -1)
            throw new InventoryException("Unavailable item: Cannot find an item with the provided id = " + id);
        return itemsList.get(index);
    }

    public ArrayList<Item> getInventory() {
        return itemsList;
    }
}
