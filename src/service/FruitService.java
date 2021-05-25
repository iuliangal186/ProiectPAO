package service;

import model.Fruit;
import model.Product;
import repository.FruitRepository;

import java.util.Optional;
import java.util.Random;

public class FruitService {
    private FruitRepository fruitRepository;

    public FruitService(){this.fruitRepository = new FruitRepository(); }

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
    public void addFruit(Fruit fruit) {fruitRepository.addFruit(fruit);}

    public Optional<Fruit> getFruitById(long id) {
        return fruitRepository.getFruitById(id);
    }

    public void updateFruitStock(long id, int stock) {fruitRepository.updateFruitStock(id, stock);}

    public void deleteFruit() {fruitRepository.deleteFruit();}
}
