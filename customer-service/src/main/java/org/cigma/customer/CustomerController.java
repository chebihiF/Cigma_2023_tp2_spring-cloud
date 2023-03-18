package org.cigma.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public void registerCustomer(CustomerRequest customerRequest){
        log.info("new customer registration {}", customerRequest);
    }
}
