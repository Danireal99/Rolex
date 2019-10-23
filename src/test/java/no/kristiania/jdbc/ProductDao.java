package no.kristiania.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao {

    private List<String> products = new ArrayList<>();
    private DataSource dataSource;

    public void insertProduct(String ProductName) {
   products.add(ProductName);

    Connection conn;
    PreparedStatement statement = conn.prepareStatement(sql:"insert into products (name) value (?)");
    statement.setString(parameterIndex: 1, ProductName);
    statement.executeUpdate();
    }




    public List<String> listAll() {
        return products;
    }
}
