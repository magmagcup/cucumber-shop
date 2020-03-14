package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.But;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) price (.+) exists with amount of (.+)")
    public void a_product_with_price_exists(String name, double price, int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        int prod_quant = catalog.getQuantity(name);
        if (quant < prod_quant) {
            order.addItem(prod, quant);
        }
    }

    @But("There aren't enough item in stock")
    public void no_item_in_stock() {
        assertEquals(0 ,order.getNumberOfOrder());
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
}

