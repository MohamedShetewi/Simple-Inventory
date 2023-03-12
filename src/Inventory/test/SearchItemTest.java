package Inventory.test;

import Inventory.Item;
import Inventory.SearchItems;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SearchItemTest {

    @Test
    public void testSearchItems() {
        ArrayList<Item> items = new ArrayList<>();

        for(int i = 0; i <= 10; i+=2) {
            items.add(new Item(i+"", "name", "des", 10));
        }
        items.add(new Item("11", "name", "des", 10));
        //items -> [0, 2, 4, 6, 8, 10, 11]
        Assert.assertEquals(0, SearchItems.searchForItemIndex("0", items));
        Assert.assertEquals(1, SearchItems.searchForItemIndex("2", items));
        Assert.assertEquals(2, SearchItems.searchForItemIndex("4", items));
        Assert.assertEquals(3, SearchItems.searchForItemIndex("6", items));
        Assert.assertEquals(4, SearchItems.searchForItemIndex("8", items));
        Assert.assertEquals(5, SearchItems.searchForItemIndex("10", items));
        Assert.assertEquals(6, SearchItems.searchForItemIndex("11", items));
    }

    @Test
    public void testSearchItemsWithUnavailableID() {
        ArrayList<Item> items = new ArrayList<>();

        for(int i = 0; i <= 10; i+=2) {
            items.add(new Item(i+"", "name", "des", 10));
        }

        //items -> [0, 2, 4, 6, 8, 10]
        Assert.assertEquals(-1, SearchItems.searchForItemIndex("5", items));
        Assert.assertEquals(-1, SearchItems.searchForItemIndex("22", items));
    }
}
