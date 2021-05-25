package service;

import model.*;

import java.util.Random;

import repository.ClothesRepository;

public class ProductService {
    private ClothesRepository clothesRepository;
    public ProductService() {this.clothesRepository = new ClothesRepository(); }

    public static Product buildClothes(String productDetails){
        String[] attr = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        String brand = attr[3];
        String season = attr[4];
        return new Clothes(new Random().nextInt(100), name, price, stock, brand, season);
    }
    public void addClothes(Clothes clothes) {clothesRepository.addClothes(clothes); }


    public static Product buildPhone(String productDetails){
        String[] attr = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        float screen = Float.valueOf(attr[3]);
        String brand = attr[4];
        String typebattery = attr[5];
        int capacitybattery = Integer.valueOf(attr[6]);
        int voltagebattery = Integer.valueOf(attr[7]);
        return new Phone(new Random().nextInt(100), name, price, stock, screen, brand,
                new Battery(typebattery, capacitybattery, voltagebattery));

    }
    public static Product buildMilk(String productDetails){
        String attr[] = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        long barcode = Long.valueOf(attr[3]);
        boolean specialEdition = Boolean.valueOf(attr[4]);
        String brand = attr[5];
        int daysToExpiration = Integer.valueOf(attr[6]);
        double volume = Double.valueOf(attr[7]);
        return new Milk(new Random().nextInt(100), name, price, stock, barcode, specialEdition, brand,
                daysToExpiration, volume);
    }
    public static Product buildFruit(String productDetails){
        String attr[] = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        long barcode = Long.valueOf(attr[3]);
        boolean specialEdition = Boolean.valueOf(attr[4]);
        String brand = attr[5];
        boolean ripe = Boolean.valueOf(attr[6]);
        return new Fruit(new Random().nextInt(100), name, price, stock, barcode, specialEdition, brand, ripe);
    }
    public static Product buildMeat(String productDetails){
        String attr[] = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        long barcode = Long.valueOf(attr[3]);
        boolean specialEdition = Boolean.valueOf(attr[4]);
        String brand = attr[5];
        int daysToExpiration = Integer.valueOf(attr[6]);
        double weigth = Double.valueOf(attr[7]);
        return new Meat(new Random().nextInt(100), name, price, stock, barcode, specialEdition, brand, daysToExpiration, weigth);
    }
}
