package org.cigma.customer;

public record CustomerRequest (
        String firstname,
        String lastName,
        String email
){}
