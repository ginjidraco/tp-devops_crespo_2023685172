package org.grostarin.springboot.demorest.repositories;

import java.util.List;

import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.springframework.data.repository.CrudRepository;

public interface ForbiddenBookRepository extends CrudRepository<ForbiddenBook, Long> {
    List<ForbiddenBook> findByTitle(String title);
}
