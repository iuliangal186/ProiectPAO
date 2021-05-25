package main;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ProductService productService = new ProductService();
        ShopService shopService = new ShopService();
        FilesService filesService = new FilesService();
        ReadService readService = new ReadService();
        ClothesService clothesService = new ClothesService();
        MilkService milkService = new MilkService();
        FruitService fruitService = new FruitService();
        MeatService meatService = new MeatService();
        readService.readProduct(shop, "csv-files/clothes.txt");
        readService.readProduct(shop, "csv-files/phone.txt");
        readService.readProduct(shop, "csv-files/milk.txt");
        readService.readProduct(shop, "csv-files/meat.txt");
        readService.readProduct(shop, "csv-files/fruit.txt");
        AuditService auditService = new AuditService();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please type a commands: add, get, update, delete, exit");
            String line = scanner.nextLine();
            switch (line){
                case "add": {
                    System.out.println("Please choose a prodcut type: clothes/food");
                    String type = scanner.nextLine();
                    switch (type){
                        case "clothes": {
                            addClothes(clothesService, scanner);
                            break;
                        }
                        case "food" :{
                            System.out.println("Please choose a food type: fruit/milk/meat");
                            String foodType = scanner.nextLine();
                            switch (foodType){
                                case "fruit":{
                                    addFruit(fruitService,scanner);
                                    break;
                                }

                                case "milk" : {
                                    addMilk(milkService, scanner);
                                    break;
                                }

                                case "meat" : {
                                    addMeat(meatService, scanner);
                                    break;
                                }
                            }
                        }
                    }
                    String message = "add";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    break;
                }
                case "get": {
                    /*
                    System.out.println("What do you want to view: ");
                    System.out.println("Fruit with the your input name -> write fruitname");
                    System.out.println("A list with all kind of fruits -> write fruitslist");
                    System.out.println("A list with all clothes for summer -> write summerclothes");
                    System.out.println("A list with all products in shop -> write products");

                    String input = scanner.nextLine();
                    switch (input) {
                        case "products": {
                            shopService.printProductDetails(shop);
                            String message = "view products";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }
                        case "fruitname": {
                            System.out.println("Give the fruit name: ");
                            String name = scanner.nextLine();
                            shopService.printFruitWithTheSameName(shop, name);
                            String message = "view fruits name";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }
                        case "fruitslist": {
                            shopService.printFruitsList(shop);
                            String message = "view all fruits";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }
                        case "summerclothes":
                            shopService.printSummerClothes(shop);
                            String message = "view summer clothes";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;

                        default: {
                            System.out.println("This view command doesn't exist");
                        }
                    }

                    break;

                     */
                    System.out.println("Please give a type of product: clothes/milk/meat/fruit");
                    String product_type = scanner.nextLine();
                    switch (product_type) {
                        case "clothes" : {
                            System.out.println("Please give the clothes-id: ");
                            Optional<Clothes> clothes = clothesService.getClothesById(Long.valueOf(scanner.nextLine()));
                            if(clothes.isPresent()) {
                                System.out.println(clothes.get());
                            }
                            break;
                        }
                        case "fruit" : {
                            System.out.println("Please give the fruit-id: ");
                            Optional<Fruit> fruit = fruitService.getFruitById(Long.valueOf(scanner.nextLine()));
                            if(fruit.isPresent()){
                                System.out.println(fruit.get());
                            }
                            break;
                        }
                        case "meat" : {
                            System.out.println("Please give the meat-id: ");
                            Optional<Meat> meat = meatService.getMeatById(Long.valueOf(scanner.nextLine()));
                            if(meat.isPresent()) {
                                System.out.println(meat.get());
                            }
                            break;
                        }
                        case "milk" : {
                            System.out.println("Please give the milk-id: ");
                            Optional<Milk> milk = milkService.getMilkById(Long.valueOf(scanner.nextLine()));
                            if(milk.isPresent()) {
                                System.out.println(milk.get());
                            }
                            break;
                        }

                    }
                    break;

                }
                case "update": {
                    System.out.println("Apply a update to clothes price -> write updateclothes");
                    System.out.println("Apply a update to fruit stock -> write updatefruit");
                    System.out.println("Apply a update to meat expiration -> write updatemeat");
                    System.out.println("Apply a update to milk special edition -> write updatemilk");
                    String input = scanner.nextLine();
                    switch (input) {
                        case "updateclothes": {
                            System.out.println("Write the id-clothes");
                            long idClothes = Long.valueOf(scanner.nextLine());
                            System.out.println("Write a new price");
                            double newPrice = Double.valueOf(scanner.nextLine());
                            clothesService.updatePriceClothes(idClothes, newPrice);
                            break;
                        }
                        case "updatefruit": {
                            System.out.println("Write the id-fruit: ");
                            long idFruit = Long.valueOf(scanner.nextLine());
                            System.out.println("Write the new stock: ");
                            int newStock = Integer.valueOf(scanner.nextLine());
                            fruitService.updateFruitStock(idFruit, newStock);
                            break;
                        }
                        case "updatemeat" : {
                            System.out.println("Write the id-meat: ");
                            long idMeat = Long.valueOf(scanner.nextLine());
                            System.out.println("Write the new expiration: ");
                            int days = Integer.valueOf(scanner.nextLine());
                            meatService.updateMeatExpiration(idMeat, days);
                            break;
                        }
                        case "updatemilk" : {
                            System.out.println("Write the id-milk: ");
                            long idMilk = Long.valueOf(scanner.nextLine());
                            System.out.println("Is this milk a special edition? ");
                            boolean edition = Boolean.valueOf(scanner.nextLine());
                            milkService.updateMilkEdition(idMilk, edition);
                            break;
                        }

                    }
                    /*
                    System.out.println("Apply a discount to all of the products -> write discountall");
                    System.out.println("Apply a discount to winter clothes -> write winterdiscount");
                    System.out.println("Apply a discount to products which daysToExpiration < 5 -> write expirationdiscount");

                    String input = scanner.nextLine();
                    switch (input){
                        case "discountall": {
                            System.out.println("Write discount between 0-1");
                            double discount = Double.valueOf(scanner.nextLine());
                            shopService.updateDiscountAll(shop, discount);
                            String message = "update -> discount all";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }
                        case "winterdiscount": {
                            System.out.println("Write discount between 0-1");
                            double discount1 = Double.valueOf(scanner.nextLine());
                            shopService.updateWinterDiscount(shop, discount1);
                            String message = "update -> winter discount";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }
                        case "expirationdiscount": {
                            System.out.println("Write discount between 0-1");
                            double discount2 = Double.valueOf(scanner.nextLine());
                            shopService.updateExpirationDiscount(shop, discount2);
                            String message = "update -> expiration discount";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                            break;
                        }

                        default:
                            System.out.println("Invalid command");
                    }
                     */
                    break;
                }
                case "delete":{
                    System.out.println("I will delete all products with stocks 0");
                    System.out.println("From which category do you want to delete the products with stocks 0?");
                    System.out.println("clothes/milk/meat/fruit");
                    String type = scanner.nextLine();
                    switch (type){
                        case "clothes": {
                            clothesService.deleteClothes();
                            break;
                        }
                        case "milk": {
                            milkService.deleteMilk();
                            break;
                        }
                        case "meat": {
                            meatService.deleteMeat();
                            break;
                        }
                        case "fruit" : {
                            fruitService.deleteFruit();
                            break;
                        }
                    }
                    break;
                    /*
                    System.out.println("Which element do you want to remove? ");
                    int number = Integer.valueOf(scanner.nextLine());
                    shopService.deleteProduct(shop, number);
                    String message = "delete product";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    break;

                     */
                }
                case "exit": {
                    String message = "exit";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    System.out.println("Done");
                    System.exit(0);
                    break;
                }

                case "create folder" : {
                    String message = "create folder";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    System.out.println("Please give the folder name ");
                    String folderName = scanner.nextLine();
                    try {
                        filesService.createFolder(folderName);
                    } catch (IOException e) {
                        System.out.println("Cannot create folder with name " + folderName);
                    }
                    break;
                }
                case "create file" : {
                    String message = "create file";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    System.out.println("Please give the file name ");
                    String fileName = scanner.nextLine();
                    try {
                        filesService.createFile(fileName);
                    } catch (IOException e) {
                        System.out.println("Cannot create file with name" + fileName);
                    }
                    break;
                }

                case "delete file" : {
                    String message = "delete file";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    System.out.println("Please give the file name to be deleted");
                    String fileName = scanner.nextLine();
                    try {
                        filesService.deleteFile(fileName);
                    } catch (IOException e) {
                        System.out.println("Cannot delete file with name" + fileName);
                    }
                    break;
                }

                case "list" : {
                    String message = "list files from folder";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                    System.out.println("Please give the folder name to list the files: ");
                    String folderName = scanner.nextLine();
                    try {
                        filesService.listFolder(folderName);
                    } catch (IOException e) {
                        System.out.println("Cannot list files from folder" + folderName);
                    }
                    break;
                }
                default: {
                    System.out.println("This command doesn't exist");
                }
            }
        }
    }

    private static void addClothes(ClothesService clothesService, Scanner scanner){
        AuditService auditService = new AuditService();
        WriteService writeService = new WriteService();
        System.out.println("Please specify name/price/stock/brand/season");
        try {
            Product product = clothesService.buildClothes(scanner.nextLine());
            clothesService.addClothes((Clothes) product);
            writeService.writeProduct(product, "csv-files/clothes.txt");
            String message = "added clothes";
            auditService.writeAction(new Action(message), "audit/audit.txt");
        } catch (NumberFormatException e){
            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for this product");
        }
    }

    private static void addMilk(MilkService milkService, Scanner scanner){
        AuditService auditService = new AuditService();
        WriteService writeService = new WriteService();
        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/volume");
        try {
            Product product = milkService.buildMilk(scanner.nextLine());
            milkService.addMilk((Milk) product);
            writeService.writeProduct(product, "csv-files/milk.txt");
            String message = "added milk";
            auditService.writeAction(new Action(message), "audit/audit.txt");
        } catch (NumberFormatException e){
            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for this product");
        }
    }

    private static void addFruit(FruitService fruitService, Scanner scanner){
        AuditService auditService = new AuditService();
        WriteService writeService = new WriteService();
        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/ripe");
        try{
            Product product = fruitService.buildFruit(scanner.nextLine());
            fruitService.addFruit((Fruit) product);
            writeService.writeProduct(product, "csv-files/fruit.txt");
            String message = "added fruits";
            auditService.writeAction(new Action(message), "audit/audit.txt");
        } catch (NumberFormatException e){
            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for this product");
        }
    }

    private static void addMeat(MeatService meatService, Scanner scanner) {
        AuditService auditService = new AuditService();
        WriteService writeService = new WriteService();
        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/weight");
        try {
            Product product = meatService.buildMeat(scanner.nextLine());
            meatService.addMeat((Meat) product);
            writeService.writeProduct(product, "csv-files/meat.txt");
            String message = "added meat";
            auditService.writeAction(new Action(message), "audit/audit.txt");
        } catch (NumberFormatException e){
            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for this product");
        }
    }

    /*
    private static void addProduct(Shop shop, ProductService productService, ShopService shopService, Scanner scanner) {
        AuditService auditService = new AuditService();
        WriteService writeService = new WriteService();
        System.out.println("Please choose a product type: clothes/phone/food");
        String productType = scanner.nextLine();
        switch (productType) {
            case "clothes" :{
                System.out.println("Please specify name/price/stock/brand/season");
                try {
                    Product product = clothesService.buildClothes(scanner.nextLine());
                    clothesService.addClothes((Clothes) product);
                    writeService.writeProduct(product, "csv-files/clothes.txt");
                    String message = "added clothes";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                } catch (NumberFormatException e){
                    System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Not enough inputs for this product");
                }
                break;
            }

            case "phone" : {
                System.out.println("Please specify name/price/stock/screen/brand/typebattery/capacitybattery/voltagebattery");
                try {
                    Product product = productService.buildPhone(scanner.nextLine());
                    shopService.addProduct(shop, product);
                    writeService.writeProduct(product, "csv-files/phone.txt");
                    String message = "added phone";
                    auditService.writeAction(new Action(message), "audit/audit.txt");
                } catch (NumberFormatException e){
                    System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Not enough inputs for this product");
                }
                break;
            }
            case "food": {
                System.out.println("Please choose a food type: (fruit/milk/meat)");
                String foodType = scanner.nextLine();
                switch (foodType) {
                    case "milk": {
                        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/volume");
                        try {
                            Product product = productService.buildMilk(scanner.nextLine());
                            shopService.addProduct(shop, product);
                            writeService.writeProduct(product, "csv-files/milk.txt");
                            String message = "added milk";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                        } catch (NumberFormatException e){
                            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Not enough inputs for this product");
                        }
                        break;
                    }
                    case "fruit": {
                        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/ripe");
                        try {
                            Product product = productService.buildFruit(scanner.nextLine());
                            shopService.addProduct(shop, product);
                            writeService.writeProduct(product, "csv-files/fruit.txt");
                            String message = "added fruit";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                        } catch (NumberFormatException e){
                            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Not enough inputs for this product");
                        }
                        break;
                    }
                    case "meat": {
                        System.out.println("Please specify name/price/stock/barccode/special_edition/brand/days to expiration/weight");
                        try {
                            Product product = productService.buildMeat(scanner.nextLine());
                            shopService.addProduct(shop, product);
                            writeService.writeProduct(product, "csv-files/meat.txt");
                            String message = "added meat";
                            auditService.writeAction(new Action(message), "audit/audit.txt");
                        } catch (NumberFormatException e){
                            System.out.println("Your inputs are invalid. The product wasn't added to the shop!");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Not enough inputs for this product");
                        }
                        break;
                    }

                }
            }

        }
    }*/

}
