package org.cigma.customer;

public record CustomerRequest (
        String firstname,
        String lastname,
        String email
){}
