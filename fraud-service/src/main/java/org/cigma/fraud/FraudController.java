package org.cigma.fraud;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudService fraudService;

    @GetMapping(path = "{customer_id}")
    public FraudCheckResponse isFraudster(@PathVariable Long customer_id){
        boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customer_id);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
