package Inventory;

public class InventoryException extends Exception {

    private String msgException;
    public InventoryException(String msgException) {
        super(msgException);
        this.msgException = msgException;
    }

    public String toString() {
        return this.msgException;
    }
}
