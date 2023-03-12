package Inventory.test;

import Inventory.Inventory;
import Inventory.InventoryException;
import Inventory.Item;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

    String mockName = "Soap";
    String mockDescription = "Used to wash hand";
    int mockQuantity = 10;

    @Test
    public void voidTestAddItem() throws InventoryException {

        Inventory inventory = getMockInventory(1);
        Item item = inventory.getInventory().get(0);

        Assert.assertEquals(item.getId(), "1");
        Assert.assertEquals(item.getName(), mockName);
        Assert.assertEquals(item.getDescription(), mockDescription);
        Assert.assertEquals(item.getQuantity(), 10);
    }

    @Test
    public void testAddItemWithNegativeQuantity() {
        Inventory inventory = new Inventory();

        InventoryException exception = Assert.assertThrows(InventoryException.class, () -> inventory.addItem(mockName, mockDescription, -1));
        Assert.assertEquals("Negative quantity: Cannot enter item with negative quantity",
                exception.toString());
    }

    @Test
    public void testRemoveItemWithValidID() throws InventoryException {
        Inventory inventory = getMockInventory(10);


        // Checking that ids from 1-10 exists
        Assert.assertEquals(10, inventory.getInventory().size());
        for (int i = 0; i < inventory.getInventory().size(); i++) {
            Assert.assertEquals((i + 1) + "", inventory.getInventory().get(i).getId());
        }

        //Removed item with id 5
        inventory.removeItem("5");

        // Checking that 5 doesn't exist anymore
        Assert.assertEquals(9, inventory.getInventory().size());
        for (Item i : inventory.getInventory())
            Assert.assertNotEquals("5", i.getId());
    }

    @Test
    public void testRemoveIDWithInvalidID() throws InventoryException {

        Inventory inventory = getMockInventory(10);
        InventoryException exception = Assert.assertThrows(InventoryException.class, () -> {
            inventory.removeItem("11");
        });
        Assert.assertEquals("Unavailable item: Cannot find an item with the provided id = 11",
                exception.toString());
        Assert.assertEquals(10, inventory.getInventory().size());
    }

    @Test
    public void testUpdateItemWithValidID() throws InventoryException {
        Inventory inventory = getMockInventory(10);
        String newName = "NEW NAME";
        String newDescription = "NEW DESCRIPTION";
        int newQuantity = 11;

        inventory.updateItem("1", newName, newDescription, newQuantity);

        Assert.assertEquals("1", inventory.getInventory().get(0).getId());
        Assert.assertEquals(newName, inventory.getInventory().get(0).getName());
        Assert.assertEquals(newDescription, inventory.getInventory().get(0).getDescription());
        Assert.assertEquals(newQuantity, inventory.getInventory().get(0).getQuantity());
    }

    @Test
    public void testUpdateItemWithInvalidID() throws InventoryException {
        Inventory inventory = getMockInventory(10);
        String newName = "NEW NAME";
        String newDescription = "NEW DESCRIPTION";
        int newQuantity = 11;

        InventoryException exception = Assert.assertThrows(InventoryException.class, () -> inventory.updateItem("11", newName, newDescription, newQuantity));
        Assert.assertEquals("Unavailable item: Cannot find an item with the provided id = 11",
                exception.toString());
    }

    @Test
    public void testUpdateItemWithNegativeQuantity() throws InventoryException {
        Inventory inventory = getMockInventory(10);
        String newName = "NEW NAME";
        String newDescription = "NEW DESCRIPTION";
        int newQuantity = -1;

        InventoryException exception = Assert.assertThrows(InventoryException.class, () -> inventory.updateItem("5", newName, newDescription, newQuantity));
        Assert.assertEquals("Negative quantity: Cannot enter item with negative quantity",
                exception.toString());
    }

    public Inventory getMockInventory(int size) throws InventoryException {
        Inventory inventory = new Inventory();
        for (int i = 0; i < size; i++) {
            inventory.addItem(mockName, mockDescription, mockQuantity);
        }
        return inventory;
    }

}
