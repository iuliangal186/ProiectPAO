package service;

import model.Meat;
import model.Milk;
import model.Product;
import repository.MeatRepository;

import java.util.Optional;
import java.util.Random;

public class MeatService {
    private MeatRepository meatRepository;

    public MeatService() {this.meatRepository = new MeatRepository();}

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
    public void addMeat(Meat meat) {meatRepository.addMeat(meat);}

    public Optional<Meat> getMeatById(long id) {
        return meatRepository.getMeatById(id);
    }

    public void updateMeatExpiration(long id, int days) {meatRepository.updateMeatExpiration(id, days);}

    public void deleteMeat() {meatRepository.deleteMeat();}

}
