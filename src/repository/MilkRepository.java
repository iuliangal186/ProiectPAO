package repository;

import config.DatabaseConnection;
import model.Milk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MilkRepository {
    public void addMilk(Milk milk) {
        String sql = "insert into milk values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, milk.getName());
            statement.setDouble(2, milk.getPrice());
            statement.setInt(3, milk.getStock());
            statement.setLong(4, milk.getBarcode());
            statement.setBoolean(5, milk.isSpecialEdition());
            statement.setString(6, milk.getBrand());
            statement.setInt(7, milk.getDaysToExpiration());
            statement.setDouble(8, milk.getVolume());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMilkEdition(long id, boolean edition) {
        String sql = "update milk set specialedition = ? where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)){
            statement.setBoolean(1, edition);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMilk() {
        String sql = "delete from milk where stock = 0";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Milk> getMilkById(long id) {
        String sql = "select * from milk m where m.id = ?";

        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long milkId = result.getLong(1);
                String name = result.getString("name");
                double price = result.getDouble("price");
                int stock = result.getInt("stock");
                long barcode = result.getLong("barcode");
                boolean specialEdition = result.getBoolean("specialEdition");
                String brand = result.getString("brand");
                int daysToExpiration = result.getInt("daysToExpiration");
                double volume = result.getDouble("volume");
                return Optional.of(new Milk(milkId, name, price, stock,barcode, specialEdition, brand, daysToExpiration, volume));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
