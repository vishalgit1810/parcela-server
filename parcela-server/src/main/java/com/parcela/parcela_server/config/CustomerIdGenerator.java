package com.parcela.parcela_server.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.stream.Stream;

public class CustomerIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String query = "SELECT c.custId FROM Customer c ORDER BY c.custId DESC";
        Stream<String> ids = session.createQuery(query, String.class).stream();

        Long maxId = ids.map(s -> s.replace("C", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return "C" + (maxId + 1);
    }
}