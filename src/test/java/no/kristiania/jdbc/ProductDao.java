package no.kristiania.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<String> products = new ArrayList<>();
    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertProduct(String ProductName) {
   products.add(ProductName);

      try (Connection conn = dataSource.getConnection();) {
       PreparedStatement statement = conn.prepareStatement(sql: "insert into products (name) value (?)");
       statement.setString( parameterIndex 1, productName);
       statement.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
    }




    public List<String> listAll() {
        return products;
    }
}
