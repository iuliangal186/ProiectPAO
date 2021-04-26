package service;

import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ReadService {
    ShopService shopService = new ShopService();
    private static Product buildClothes(String productDetails){
        String[] attr = productDetails.split("/");
        int id = Integer.valueOf(attr[0]);
        String name = attr[1];
        float price = Float.valueOf(attr[2]);
        int stock = Integer.valueOf(attr[3]);
        String brand = attr[4];
        String season = attr[5];
        return new Clothes(id, name, price, stock, brand, season);
    }

    public static Product buildPhone(String productDetails){
        String[] attr = productDetails.split("/");
        int id = Integer.valueOf(attr[0]);
        String name = attr[1];
        float price = Float.valueOf(attr[2]);
        int stock = Integer.valueOf(attr[3]);
        float screen = Float.valueOf(attr[4]);
        String brand = attr[5];
        String typebattery = attr[6];
        int capacitybattery = Integer.valueOf(attr[7]);
        int voltagebattery = Integer.valueOf(attr[8]);
        return new Phone(id, name, price, stock, screen, brand,
                new Battery(typebattery, capacitybattery, voltagebattery));

    }
    public static Product buildMilk(String productDetails){
        String attr[] = productDetails.split("/");
        int id = Integer.valueOf(attr[0]);
        String name = attr[1];
        float price = Float.valueOf(attr[2]);
        int stock = Integer.valueOf(attr[3]);
        long barcode = Long.valueOf(attr[4]);
        boolean specialEdition = Boolean.valueOf(attr[5]);
        String brand = attr[6];
        int daysToExpiration = Integer.valueOf(attr[7]);
        double volume = Double.valueOf(attr[8]);
        return new Milk(id, name, price, stock, barcode, specialEdition, brand,
                daysToExpiration, volume);
    }
    public static Product buildFruit(String productDetails){
        String attr[] = productDetails.split("/");
        int id = Integer.valueOf(attr[0]);
        String name = attr[1];
        float price = Float.valueOf(attr[2]);
        int stock = Integer.valueOf(attr[3]);
        long barcode = Long.valueOf(attr[4]);
        boolean specialEdition = Boolean.valueOf(attr[5]);
        String brand = attr[6];
        boolean ripe = Boolean.valueOf(attr[7]);
        return new Fruit(id, name, price, stock, barcode, specialEdition, brand, ripe);
    }
    public static Product buildMeat(String productDetails){
        String attr[] = productDetails.split("/");
        int id = Integer.valueOf(attr[0]);
        String name = attr[1];
        float price = Float.valueOf(attr[2]);
        int stock = Integer.valueOf(attr[3]);
        long barcode = Long.valueOf(attr[4]);
        boolean specialEdition = Boolean.valueOf(attr[5]);
        String brand = attr[6];
        int daysToExpiration = Integer.valueOf(attr[7]);
        double weigth = Double.valueOf(attr[8]);
        return new Meat(id, name, price, stock, barcode, specialEdition, brand, daysToExpiration, weigth);
    }
    public void readProduct(Shop shop, String fileName) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.replace(',', '/');
                if ("csv-files/clothes.txt".equals(fileName)) {
                    shopService.addProduct(shop, buildClothes(line));
                }
                if ("csv-files/phone.txt".equals(fileName)) {
                    shopService.addProduct(shop, buildPhone(line));
                }
                if ("csv-files/meat.txt".equals(fileName)) {
                    shopService.addProduct(shop, buildMeat(line));
                }
                if ("csv-files/milk.txt".equals(fileName)) {
                    shopService.addProduct(shop, buildMilk(line));
                }
                if ("csv-files/fruit.txt".equals(fileName)) {
                    shopService.addProduct(shop, buildFruit(line));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
