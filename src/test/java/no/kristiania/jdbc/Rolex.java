package no.kristiania.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class Rolex {

    @Test
    void shouldRetrieveStoredProduct() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:test");

        dataSource.getConnection().createStatement().executeUpdate(
                "create table products (name varchar(100))"
        );

        ProductDao dao = new ProductDao(dataSource);
        String productName = pickOne(new String[]{"Rolex", "Hublot", "Taghauer", "Omega", "Baume&Mercier"});
        dao.insertProduct(productName);
        assertThat(dao.listAll()).contains(productName);

    }

    private String pickOne(String[] strings) {
        return strings[new Random().nextInt(strings.length)];
    }

}