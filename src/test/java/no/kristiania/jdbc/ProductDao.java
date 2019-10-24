package no.kristiania.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {


    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertProduct(String productName) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
       PreparedStatement statement = conn.prepareStatement(
               sql: "insert into products (name) values (?)"
          );
       statement.setString(  1, productName);
       statement.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
    }


    public List<String> listAll() {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    sql: "select * from products"
            ) {
                try (ResultSet rs = statement.executeQuerry())
                List<String> result = new ArrayList<>();

                while (rs.next()) {
                    result.add(rs.getString(columnLabel "name"));

                }
                return result;
            }
        }


public static void main (String[] args) throws SQLException {
            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setUrl("jdbc:postgres://localhost:5432/rolex");
            dataSource.setUser("rolex");
            dataSource.setPassword("password");
            ProductDao productDao = new ProductDao(new PGSimpleDataSource());
            productDao.insertProduct( productName: "Test");
        }
    }
}
