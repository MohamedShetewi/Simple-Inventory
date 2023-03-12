package Inventory;

import java.util.ArrayList;

public class SearchItems {
    /**
     * This method searches for the inventory item in O(log n)
     * Disclaimer: It assumes the ids are integers. So, if the identifiers generation changed,
     * this needs to be updated.
     * Also it assumes that all elements are distinct
     */
    public static int searchForItemIndex(String id, ArrayList<Item> itemsList) {
        int minIdx = 0;
        int maxIdx = itemsList.size() - 1;
        int intID = Integer.parseInt(id);

        while (minIdx <= maxIdx) {
            int mid = (minIdx + maxIdx) / 2;
            int midItemID = Integer.parseInt(itemsList.get(mid).getId());
            if (intID == midItemID)
                return mid;
            if (midItemID < intID) {
                minIdx = mid + 1;
            } else {
                maxIdx = mid - 1;
            }
        }
        return -1;
    }
}
