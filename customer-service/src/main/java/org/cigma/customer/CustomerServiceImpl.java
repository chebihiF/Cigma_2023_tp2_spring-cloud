package org.cigma.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstname())
                .lastName(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
        // TODO: check email valid
        // TODO: check id email not taken
        customerRepository.save(customer);
    }
}
