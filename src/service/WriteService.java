package service;

import model.*;

import java.io.*;
import java.nio.file.*;

public class WriteService {
    public void writeProduct(Product product, String FILE_PATH) {
        if (product instanceof Clothes) {
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardOpenOption.APPEND);
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() +
                        "," + product.getStock() + "," + ((Clothes) product).getBrand() + "," + ((Clothes) product).getSeason() + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (product instanceof Phone){
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardOpenOption.APPEND);
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() +
                        "," + product.getStock() + "," + ((Phone) product).getScreen() + "," + ((Phone) product).getBrand() + "," +
                        ((Phone) product).getBattery().getType() + "," +
                        ((Phone) product).getBattery().getCapacity() + "," + ((Phone) product).getBattery().getVoltage() + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (product instanceof Milk) {
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardOpenOption.APPEND);
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() +
                        "," + product.getStock() + "," + ((Milk) product).getBarcode() + "," + ((Milk) product).isSpecialEdition()
                        + "," + ((Milk) product).getBrand() + "," +
                        ((Milk) product).getDaysToExpiration() + "," + ((Milk) product).getVolume() + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (product instanceof Meat) {
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardOpenOption.APPEND);
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() +
                        "," + product.getStock() + "," + ((Meat) product).getBarcode() + "," + ((Meat) product).isSpecialEdition()
                        + "," + ((Meat) product).getBrand() + "," + ((Meat) product).getDaysToExpiration() + "," + ((Meat) product).getWeight() + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (product instanceof Fruit) {
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardOpenOption.APPEND);
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() +
                        "," + product.getStock() + "," + ((Fruit) product).getBarcode() + "," + ((Fruit) product).isSpecialEdition()
                        + "," + ((Fruit) product).getBrand() + "," + ((Fruit) product).isRipe() + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
