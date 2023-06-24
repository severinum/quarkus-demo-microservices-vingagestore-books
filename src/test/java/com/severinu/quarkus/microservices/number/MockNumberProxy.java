package com.severinu.quarkus.microservices.number;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {
    @Override
    public IsbnThirteen generateIsbnNumbers() {
        return new IsbnThirteen("13-mock");
    }
}
