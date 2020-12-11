package cz.spring.cipher.repository;

import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class CipherRepository implements ICipherRepository {

    public Iterable findAll() {
        // TODO: Implementation of method to return list of pair <key, code>
        return Collections.emptyList();
    }
}
