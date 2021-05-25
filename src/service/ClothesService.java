package service;

import model.Clothes;
import model.Product;
import repository.ClothesRepository;

import java.util.Optional;
import java.util.Random;

public class ClothesService {
    private ClothesRepository clothesRepository;

    public ClothesService() {this.clothesRepository = new ClothesRepository(); }

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

    public Optional<Clothes> getClothesById(long id) {
        return clothesRepository.getClothesById(id);
    }

    public void updatePriceClothes(long id, double price) {clothesRepository.updateClothesPrice(id, price);}

    public void deleteClothes() {clothesRepository.deleteClothes();}
}
