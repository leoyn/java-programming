package semester1.chapter10.Task4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static final String FILE_PATH = "customers.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner ioScanner = new Scanner(new File(FILE_PATH));

        byte state = 1;

        Customer customer = new Customer("", "", 0);

        while(ioScanner.hasNextLine()) {
            String line = ioScanner.nextLine();

            switch(state) {
                case 1:
                    if(line.startsWith("Customer:")) {
                        String[] customerParts = line.substring("Customer:".length()).split(",");
                        customer = new Customer(customerParts[0], customerParts[1], Integer.parseInt(customerParts[2]));
                        state = 2;
                    }
                    break;
                case 2:
                    if(line.startsWith("privateAddress:")) {
                        String[] privateAddressParts = line.substring("privateAddress:".length()).split(",");
                        Address privateAddress = new Address(privateAddressParts[0], Integer.parseInt(privateAddressParts[1]), Integer.parseInt(privateAddressParts[2]), privateAddressParts[3]);
                        customer.setPrivateAddress(privateAddress);
                        state = 3;
                    }
                    break;
                case 3:
                    if(line.startsWith("businessAdress:")) {
                        String[] businessAddressParts = line.substring("businessAdress:".length()).split(",");
                        Address businessAddress = new Address(businessAddressParts[0], Integer.parseInt(businessAddressParts[1]), Integer.parseInt(businessAddressParts[2]), businessAddressParts[3]);
                        customer.setBusinessAddress(businessAddress);
                        state = 4;
                    }
                    break;
                case 4:
                    if(line.startsWith("Order:")) {
                        String[] orderParts = line.substring("Order:".length()).split(",");
                        Order order = new Order(Integer.parseInt(orderParts[0]), Integer.parseInt(orderParts[1]), Float.parseFloat(orderParts[2]));
                        customer.addOder(order);
                        state = 4;
                    }
            }
            
            if(line.startsWith("-")) {
                if(state >= 3) {
                    printCustomerInformation(customer);
                    System.out.println("--------");
                }
                state = 1;
            }
        }

        ioScanner.close();
    }

    public static void printCustomerInformation(Customer customer) {
        System.out.println("#" + customer.customerId + " " + customer.firstname + ", " + customer.lastname);
        System.out.println("Private Address: " + customer.privateAdress.street + " " + customer.privateAdress.number + ", " + customer.privateAdress.zipCode + " " + customer.privateAdress.city);
        System.out.println("Business Address: " + customer.businessAddress.street + " " + customer.businessAddress.number + ", " + customer.businessAddress.zipCode + " " + customer.businessAddress.city);
        System.out.println("Orders:");

        for(int i = 0; i < customer.orders.length; i++) {
            System.out.println("#" + customer.orders[i].itemId + " " + customer.orders[i].amount + "x " + customer.orders[i].price);
        }
    }
}