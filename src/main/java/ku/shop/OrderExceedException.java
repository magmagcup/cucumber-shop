package ku.shop;

public class OrderExceedException extends Exception{
    public OrderExceedException(){
        super("Order exceed products amount.");
    }
}
