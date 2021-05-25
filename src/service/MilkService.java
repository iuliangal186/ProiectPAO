package service;

import model.Milk;
import model.Product;
import repository.MilkRepository;

import java.util.Optional;
import java.util.Random;

public class MilkService {
    private MilkRepository milkRepository;

    public MilkService() {this.milkRepository = new MilkRepository();}

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
    public void addMilk(Milk milk) {milkRepository.addMilk(milk);}

    public Optional<Milk> getMilkById(long id) {
        return milkRepository.getMilkById(id);
    }

    public void updateMilkEdition(long id, boolean edition) {milkRepository.updateMilkEdition(id, edition);}

    public void deleteMilk() {milkRepository.deleteMilk();}
}
