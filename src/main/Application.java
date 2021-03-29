package main;

import model.*;
import service.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopService shopService = new ShopService();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please type a commands: add, view, update, delete, exit");
            String line = scanner.nextLine();
            switch (line){
                case "add": {
                    System.out.println("Please choose a product type: (clothes/phone/food)");
                    String productType = scanner.nextLine();
                    switch (productType) {
                        case "clothes": {
                            System.out.println("Please specify name/price/stock/brand/season");
                            shopService.addProduct(shop, buildClothes(scanner.nextLine()));
                            break;
                        }
                        case "phone": {
                            System.out.println("Please specify name/price/stock/screen/brand/typebattery/capacitybattery/voltagebattery");
                            shopService.addProduct(shop, buildPhone(scanner.nextLine()));
                            break;
                        }
                        case "food": {
                            System.out.println("Please choose a food type: (fruit/milk/meat)");
                            String foodType = scanner.nextLine();
                            switch (foodType) {
                                case "milk": {
                                    System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/volume");
                                    shopService.addProduct(shop, buildMilk(scanner.nextLine()));
                                    break;
                                }
                                case "fruit": {
                                    System.out.println("Please specify name/price/stock/barccode/special_edition/brand/ripe");
                                    shopService.addProduct(shop, buildFruit(scanner.nextLine()));
                                    break;
                                }
                                case "meat": {
                                    System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/weight");
                                    shopService.addProduct(shop, buildMeat(scanner.nextLine()));
                                    break;
                                }

                            }
                        }
                    }
                break;
                }
                case "view": {
                    System.out.println("What do you want to view: ");
                    System.out.println("Fruit with the your input name -> write fruitname");
                    System.out.println("A list with all kind of fruits -> write fruitslist");
                    System.out.println("A list with all clothes for summer -> write summerclothes");
                    System.out.println("A list with all products in shop -> write products");

                    String input = scanner.nextLine();
                    switch (input) {
                        case "products":
                            shopService.printProductDetails(shop);
                            break;

                        case "fruitname":
                            System.out.println("Give the fruit name: ");
                            String name = scanner.nextLine();
                            shopService.printFruitWithTheSameName(shop, name);
                            break;

                        case "fruitslist":
                            shopService.printFruitsList(shop);
                            break;

                        case "summerclothes":
                            shopService.printSummerClothes(shop);
                            break;

                        default: {
                            System.out.println("This view command doesn't exist");
                        }
                    }

                    break;
                }
                case "update": {
                    System.out.println("Apply a discount to all of the products -> write discountall");
                    System.out.println("Apply a discount to winter clothes -> write winterdiscount");
                    System.out.println("Apply a discount to products which daysToExpiration < 5 -> write expirationdiscount");

                    String input = scanner.nextLine();
                    switch (input){
                        case "discountall":
                            System.out.println("Write discount between 0-1");
                            double discount = Double.valueOf(scanner.nextLine());
                            shopService.updateDiscountAll(shop, discount);
                            break;

                        case "winterdiscount":
                            System.out.println("Write discount between 0-1");
                            double discount1 = Double.valueOf(scanner.nextLine());
                            shopService.updateWinterDiscount(shop, discount1);
                            break;

                        case "expirationdiscount":
                            System.out.println("Write discount between 0-1");
                            double discount2 = Double.valueOf(scanner.nextLine());
                            shopService.updateExpirationDiscount(shop, discount2);
                            break;

                        default:
                            System.out.println("Invalid command");
                    }
                    break;
                }
                case "delete":{
                    System.out.println("Which element do you want to remove? ");
                    int number = Integer.valueOf(scanner.nextLine());
                    shopService.deleteProduct(shop, number);
                    break;
                }
                case "exit": {
                    System.out.println("Done");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("This command doesn't exist");
                }
            }
        }
    }
    public static Product buildClothes(String productDetails){
        String[] attr = productDetails.split("/");
        String name = attr[0];
        float price = Float.valueOf(attr[1]);
        int stock = Integer.valueOf(attr[2]);
        String brand = attr[3];
        String season = attr[4];
        return new Clothes(new Random().nextInt(100), name, price, stock, brand, season);
    }

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
