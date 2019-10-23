package no.kristiania.jdbc;

import org.junit.jupiter.api.Test;

public class Rolex {

@Test


void shouldRetrieveStoredProduct() {

    ProductDao dao = new ProductDao();
    dao.insertProduct("Rolex");
    assertThat(dao.listAll()).contains("Rolex");

}
}