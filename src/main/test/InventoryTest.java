package main.test;

import main.Inventory;
import main.InventoryException;
import main.Item;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

    @Test
    public void voidTestAddItem() throws InventoryException {
        String name = "Soap";
        String description = "Used to wash hand";
        int quantity = 10;

        Inventory inventory = new Inventory();
        inventory.addItem(name, description, quantity);
        Item item = inventory.getInventory().get(0);

        Assert.assertEquals(item.getId(), "1");
        Assert.assertEquals(item.getName(), name);
        Assert.assertEquals(item.getDescription(), description);
        Assert.assertEquals(item.getQuantity(), 10);
    }

    @Test
    public void testAddItemWithNegativeQuantity() {
        String name = "Soap";
        String description = "Used to wash hand";
        int quantity = 10;

        Inventory inventory = new Inventory();
        try {
            inventory.addItem(name, description, quantity);
        } catch (InventoryException exception) {
            Assert.assertEquals(exception.toString(), "Negative quantity: Cannot enter item with negative quantity");
            Assert.assertEquals(inventory.getInventory().size(), 0);
        }

    }
}
