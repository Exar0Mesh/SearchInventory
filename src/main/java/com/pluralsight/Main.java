package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: \n");

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d - name: %s - price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader bufReader = new BufferedReader(fileReader);
        String input;

        while((input = bufReader.readLine()) !=null) {
            String[] lineSplit = input.split(Pattern.quote("|"));
            int id = Integer.parseInt(lineSplit[0]);
            String names = lineSplit[1];
            float price = Float.parseFloat(lineSplit[2]);
            Product object = new Product(id, names, price);
            System.out.print("id: " + object.getId() + " - ");
            System.out.print("name: " + object.getName() + " - ");
            System.out.print("price: " + object.getPrice() + "\n");
        }


        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
        }

    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(3503, "Chips", 6.99F));
        return inventory;
    }
}