package service;

import model.*;

import java.time.Period;
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
    private void printProduct(Product p)
    {
        System.out.println(p);
    }


    public void printFruitWithTheSameName(Shop shop, String name)
    {
        for(Product p : shop.getProducts()){
            if (p != null){
                Fruit p1 = new Fruit();
                p1.setName(name);
                if(p1.equals(p)){
                    System.out.println(p);
                }
            }
        }
    }

    public void printFruitsList(Shop shop){
        int k = 0;
        String[] names;
        names = new String[10];
        for (Product p : shop.getProducts()){
            if(p != null){
                if(p instanceof Fruit) {
                    String name = p.getName();
                    int ok = 0;
                    for (String n : names) {
                        if(n != null) {
                            if (n.equals(name)) {
                                ok = 1;
                            }
                        }
                    }
                    if (ok == 0) {
                        System.out.println(name);
                        names[k] = name;
                        k++;
                    }

                }    }
        }
    }
    public void printSummerClothes(Shop shop){
        for(Product p : shop.getProducts()){
            if(p != null){
                if (p instanceof Clothes){
                    String type = ((Clothes)p).getSeason();
                    if(type.equals("summer")){
                        printProduct(p);
                    }

                }
            }
        }
    }
    public void updateDiscountAll(Shop shop, double discount){

        for (int i = 0; i < shop.getProducts().length; i++){
            Product p = shop.getProducts()[i];
            if(p != null) {
                double x = p.getPrice();
                x = x - x * discount;
                p.setPrice(x);
                shop.getProducts()[i] = p;
            }
        }
    }

    public void updateWinterDiscount(Shop shop, double discount){
        for(int i = 0; i < shop.getProducts().length; i++){
            Product p = shop.getProducts()[i];
            if(p != null && p instanceof Clothes){
                String season = ((Clothes) p).getSeason();
                if(season.equals("winter"))
                {
                    double x = p.getPrice();
                    x = x - x * discount;
                    p.setPrice(x);
                    shop.getProducts()[i] = p;
                }
            }
        }
    }
    public void updateExpirationDiscount(Shop shop, double discount) {
        for (int i = 0; i < shop.getProducts().length; i++) {
            Product p = shop.getProducts()[i];
            if (p != null && p instanceof Milk) {
                int days = ((Milk) p).getDaysToExpiration();
                if (days < 5) {
                    double x = p.getPrice();
                    x = x - x * discount;
                    p.setPrice(x);
                    shop.getProducts()[i] = p;
                }
            }
            if (p != null && p instanceof Meat) {
                int days = ((Meat) p).getDaysToExpiration();
                if (days < 5) {
                    double x = p.getPrice();
                    x = x - x * discount;
                    p.setPrice(x);
                    shop.getProducts()[i] = p;
                }
            }
        }
    }
    public void deleteProduct(Shop shop, int pos){
        int size = shop.getProducts().length;
        if(size - 1 < pos)
            System.out.println("We don't have a product indexed with " + pos);
        else {
            for (int i = pos; i < size - 1; i++) {
                shop.getProducts()[i] = shop.getProducts()[i + 1];
            }
            shop.getProducts()[size - 1] = null;
        }
    }

}
