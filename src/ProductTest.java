import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @org.junit.jupiter.api.Test
    void setName() {
        Product product = new Product("Apple", "Red", "123456", 0.50);
        product.setName("Banana");
        assertEquals("Banana", product.getName());
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        Product product = new Product("Apple", "Red", "123456", 0.50);
        product.setDescription("Yellow");
        assertEquals("Yellow", product.getDescription());
    }

    @org.junit.jupiter.api.Test
    void setCost() {
        Product product = new Product("Apple", "Red", "123456", 0.50);
        product.setCost(0.75);
        assertEquals(0.75, product.getCost());
    }

    @org.junit.jupiter.api.Test
    void toCSVDataRecord() {
        Product product = new Product("Apple", "Red", "123456", 0.50);
        assertEquals("Apple,Red,123456,0.5", product.toCSVDataRecord());
    }

    @org.junit.jupiter.api.Test
    void toJSONDataRecord() {
        Product product = new Product("Apple", "Red", "123456", 0.50);
        assertEquals("\"name\":\"Apple\",\"description\":\"Red\",\"ID\":\"123456\",\"cost\":0.5", product.toJSONDataRecord());
    }
}