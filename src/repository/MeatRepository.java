package repository;

import config.DatabaseConnection;
import model.Clothes;
import model.Meat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MeatRepository {

    public void addMeat(Meat meat) {
        String sql = "insert into meat values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, meat.getName());
            statement.setDouble(2, meat.getPrice());
            statement.setInt(3, meat.getStock());
            statement.setLong(4, meat.getBarcode());
            statement.setBoolean(5, meat.isSpecialEdition());
            statement.setString(6, meat.getBrand());
            statement.setInt(7, meat.getDaysToExpiration());
            statement.setDouble(8, meat.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMeatExpiration (long id, int days) {
        String sql = "update meat set daystoexpiration = ? where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, days);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeat() {
        String sql = "delete from meat where stock = 0";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Meat> getMeatById(long id){
        String sql = "select * from meat m where m.id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long meatId = result.getLong(1);
                String name = result.getString("name");
                double price = result.getDouble("price");
                int stock = result.getInt("stock");
                long barcode = result.getLong("barcode");
                boolean specialEdition = result.getBoolean("specialEdition");
                String brand = result.getString("brand");
                int daysToExpiration = result.getInt("daysToExpiration");
                double weight = result.getDouble("weight");

                return Optional.of(new Meat(meatId, name, price, stock, barcode, specialEdition, brand, daysToExpiration, weight));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
