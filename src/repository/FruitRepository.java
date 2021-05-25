package repository;

import config.DatabaseConnection;
import model.Fruit;
import model.Milk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class FruitRepository {
    public void addFruit(Fruit fruit) {
        String sql = "insert into fruit values(null, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, fruit.getName());
            statement.setDouble(2, fruit.getPrice());
            statement.setInt(3, fruit.getStock());
            statement.setLong(4, fruit.getBarcode());
            statement.setBoolean(5, fruit.isSpecialEdition());
            statement.setString(6, fruit.getBrand());
            statement.setBoolean(7, fruit.isRipe());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateFruitStock(long id, int stock) {
        String sql = "update fruit set stock = ? where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFruit() {
        String sql = "delete from fruit where stock = 0";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Fruit> getFruitById(long id) {
        String sql = "select * from fruit f where f.id = ?";

        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)){
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                long fruitId = result.getLong(1);
                String name = result.getString("name");
                double price = result.getDouble("price");
                int stock = result.getInt("stock");
                long barcode = result.getLong("barcode");
                boolean specialEdition = result.getBoolean("specialEdition");
                String brand = result.getString("brand");
                boolean ripe = result.getBoolean("ripe");

                return Optional.of(new Fruit(fruitId, name, price, stock, barcode, specialEdition, brand, ripe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
