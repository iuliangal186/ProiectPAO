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
            System.out.println("Please type a commands: add, view, exit");
            String line = scanner.nextLine();
            switch (line){
                case "add":
                    System.out.println("Please choose a product type: (clothes/phone/food)");
                    String productType = scanner.nextLine();
                    switch (productType){
                        case "clothes": {
                            System.out.println("Please specify name/price/stock/brand/season");
                            shopService.addProduct(shop, shopService.buildClothes(scanner.nextLine()));
                            break;
                        }
                        case "phone": {
                            System.out.println("Please specify name/price/stock/screen/brand/typebattery/capacitybattery/voltagebattery");
                            shopService.addProduct(shop, shopService.buildPhone(scanner.nextLine()));
                            break;
                        }
                        case "food":{
                            System.out.println("Please choose a food type: (fruit/milk/meat)");
                            String foodType = scanner.nextLine();
                            
                        }

                    }
            }
        }
    }

}
