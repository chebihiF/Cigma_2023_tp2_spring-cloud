package org.cigma.customer;

import lombok.RequiredArgsConstructor;
import org.cigma.customer.service.FraudFeignService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final FraudFeignService fraudFeignService;
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
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudFeignService.isFraudster(customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        // TODO: send notification
    }
}
