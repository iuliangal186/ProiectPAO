package repository;

import config.DatabaseConnection;
import model.Clothes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ClothesRepository {
    public void addClothes(Clothes clothes){
        String sql = "insert into clothes values(null, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, clothes.getName());
            statement.setDouble(2, clothes.getPrice());
            statement.setInt(3, clothes.getStock());
            statement.setString(4, clothes.getBrand());
            statement.setString(5, clothes.getSeason());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Clothes> getClothesById(long id){
        String sql = "select * from clothes c where c.id = ?";

        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                long clothesId = result.getLong(1);
                String name = result.getString("name");
                double price = result.getDouble("price");
                int stock = result.getInt("stock");
                String brand = result.getString("brand");
                String season = result.getString("season");

                return Optional.of(new Clothes(clothesId, name, price, stock, brand, season));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateClothesPrice (long id, double price){
        String sql = "update clothes set price = ? where id = ? ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setDouble(1, price);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClothes() {
        String sql = "delete from clothes where stock = 0";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
