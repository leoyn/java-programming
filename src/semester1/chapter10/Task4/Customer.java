package semester1.chapter10.Task4;

public class Customer {
    public String firstname;
    public String lastname;
    public int customerId;
    public Address privateAdress;
    public Address businessAddress;
    public Order[] orders = new Order[0];

    public Customer(String firstname, String lastname, int customerId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = customerId;
    }

    public void setPrivateAddress(Address privateAddress) {
        this.privateAdress = privateAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    public void addOder(Order order) {
        Order[] orders = new Order[this.orders.length + 1];

        for(int i = 0; i < this.orders.length; i++) {
            orders[i] = this.orders[i];
        }

        orders[this.orders.length] = order;

        this.orders = orders;
    }
}