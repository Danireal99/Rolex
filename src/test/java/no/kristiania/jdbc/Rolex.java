package no.kristiania.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class Rolex {

@Test


void shouldRetrieveStoredProduct() {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl("jdbc:h2:mem:test");
    ProductDao dao = new ProductDao(new JdbcDataSource());
    String ProductName = PickOne(new String[]{"Rolex","Hublot","Taghauer","Omega","Baume&Mercier"});
    dao.insertProduct(ProductName);
    assertThat(dao.listAll()).contains(ProductName);

}

    private String PickOne(String[] strings) {
    return strings[new Random().nextInt(strings.length)];
    }

}