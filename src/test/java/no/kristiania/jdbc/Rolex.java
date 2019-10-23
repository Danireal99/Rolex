package no.kristiania.jdbc;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Rolex {

@Test


void shouldRetrieveStoredProduct() {

    ProductDao dao = new ProductDao();
    dao.insertProduct("Role");
    assertThat(dao.listAll()).contains("Rolex");

}
}