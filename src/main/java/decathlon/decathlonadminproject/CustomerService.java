package decathlon.decathlonadminproject;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer() {
        // Logic to retrieve the customer information
        // Replace with your implementation
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhoneNumber("1234567890");
        return customer;
    }
}
