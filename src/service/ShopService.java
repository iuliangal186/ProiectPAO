package service;

import model.*;

import java.util.*;

public class ShopService {
    private int getNumberOfProducts(Shop shop){
        int numberOfProducts = 0;
        for (Product p : shop.getProducts()){
            if (p != null){
                numberOfProducts ++;
            }
        }
        return numberOfProducts;
    }

    public void addProduct(Shop shop, Product product)
    {
        int Index = getNumberOfProducts(shop);
        shop.getProducts()[Index] = product;
    }

    public void printProductDetails(Shop shop){
        for(Product p : shop.getProducts()){
            if(p != null){
                System.out.println(p);
            }
        }
    }
    public Product buildClothes(String productDetails){
        String[] attr = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        String brand = attr[3];
        String season = attr[4];
        return new Clothes(new Random().nextInt(100), name, price, stock, brand, season);
    }

    public Product buildPhone(String productDetails){
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


}
