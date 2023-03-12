package Main;

import Inventory.Inventory;
import Inventory.InventoryException;
import Inventory.Item;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    static Inventory inventory = new Inventory();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder welcomePrint = new StringBuilder();
        welcomePrint.append("Welcome to the inventory!!\n\n")
                .append("You can do the following functionalities in the inventory:\n")
                .append("1- Add Item (enter \"-add\")\n")
                .append("2- Remove Item (enter \"-remove\")\n")
                .append("3- Update Item (enter \"-update\")\n")
                .append("4- Get Item (enter \"-get\") \n")
                .append("5- Get All Items (enter \"-getAll\")\n");
        System.out.println(welcomePrint);

        while (true) {
            System.out.println("Please enter your command:>");
            String command = sc.nextLine().strip();
            switch (command) {
                case "-add" -> handleAddItem();
                case "-remove" -> handleRemoveItem();
                case "-update" -> handleUpdateItem();
                case "-get" -> handleGetItem();
                case "-getAll" -> handleGetAllItems();
                default -> System.out.println("Invalid command");
            }
        }
    }

    static void handleGetAllItems() {
        System.out.println("-------------------------");
        for (Item item : inventory.getInventory())
            System.out.println(item.toString());
        System.out.println("-------------------------");
    }

    static void handleGetItem() {
        System.out.println("Please enter the following on a separated lines");
        System.out.println("Item ID: ");
        String id = sc.nextLine();
        try {
            System.out.println(inventory.getItem(id).toString());
        } catch (InventoryException e) {
            System.out.println(e);
        }
    }

    static void handleUpdateItem() {
        System.out.println("Please enter the following on a separated lines");
        System.out.println("Item ID: ");
        String id = sc.nextLine();
        System.out.println("Name: ");
        String newName = sc.nextLine();
        System.out.println("Description: ");
        String newDescription = sc.nextLine();
        System.out.println("Quantity: ");
        String quantityText = sc.nextLine();
        int newQuantity = 0;
        try {
            newQuantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity: the quantity must be a number!!");
            return;
        }
        try {
            inventory.updateItem(id, newName, newDescription, newQuantity);
            System.out.println("Update Successfully!!");
        } catch (InventoryException e) {
            System.out.println(e);
        }
    }

    static void handleRemoveItem() {
        System.out.println("Please enter the following on a separated lines");
        System.out.println("Item ID: ");
        String id = sc.nextLine();
        try {
            inventory.removeItem(id);
            System.out.println("Removed Successfully");
        } catch (InventoryException e) {
            System.out.println(e);
        }
    }

    static void handleAddItem() {
        System.out.println("Please enter the following on a separated lines");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Description: ");
        String description = sc.nextLine();
        System.out.println("Quantity: ");
        String quantityText = sc.nextLine();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity: the quantity must be a number!!");
            return;
        }
        try {
            inventory.addItem(name, description, quantity);
            System.out.println("Added Successfully!!");
        } catch (InventoryException e) {
            System.out.println(e);
        }
    }


}