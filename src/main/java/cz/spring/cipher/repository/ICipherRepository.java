package cz.spring.cipher.repository;

import org.springframework.stereotype.Repository;

public interface ICipherRepository<T> {

    // find all
    Iterable<T> findAll();

}
