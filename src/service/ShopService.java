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
        shop.getProducts().add(product);
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
                if(p.getName().equals(name)){
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

        for (int i = 0; i < shop.getProducts().size(); i++){
            Product p = shop.getProducts().get(i);
            if(p != null) {
                double copy = p.getPrice();
                copy = copy - copy * discount;
                p.setPrice(copy);
                shop.getProducts().set(i, p);
            }
        }
    }

    public void updateWinterDiscount(Shop shop, double discount){
        for(int i = 0; i < shop.getProducts().size(); i++){
            Product p = shop.getProducts().get(i);
            if(p != null && p instanceof Clothes){
                String season = ((Clothes) p).getSeason();
                if("winter".equals(season))
                {
                    double copy = p.getPrice();
                    copy = copy - copy * discount;
                    p.setPrice(copy);
                    shop.getProducts().set(i, p);
                }
            }
        }
    }
    public void updateExpirationDiscount(Shop shop, double discount) {
        for (int i = 0; i < shop.getProducts().size(); i++) {
            Product p = shop.getProducts().get(i);
            if (p != null && p instanceof Milk) {
                int days = ((Milk) p).getDaysToExpiration();
                if (days < 5) {
                    double x = p.getPrice();
                    x = x - x * discount;
                    p.setPrice(x);
                    shop.getProducts().set(i, p);
                }
            }
            if (p != null && p instanceof Meat) {
                int days = ((Meat) p).getDaysToExpiration();
                if (days < 5) {
                    double copy = p.getPrice();
                    copy = copy - copy * discount;
                    p.setPrice(copy);
                    shop.getProducts().set(i, p);
                }
            }
        }
    }
    public void deleteProduct(Shop shop, int pos){
        int size = shop.getProducts().size();
        shop.getProducts().remove(pos);
    }

}
