package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.BookIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookNotFoundException;
import org.grostarin.springboot.demorest.repositories.ForbiddenBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ForbiddenBookServices {    

    @Autowired
    private ForbiddenBookRepository bookRepository;
    
    public Iterable<ForbiddenBook> findAll(BookSearch bookSearchDTO) {
        if(bookSearchDTO!=null && StringUtils.hasText(bookSearchDTO.title())) {
            return bookRepository.findByTitle(bookSearchDTO.title());  
        }
        return bookRepository.findAll();
    }

    public ForbiddenBook findOne(long id) {
        return bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
    }

    public ForbiddenBook create(ForbiddenBook book) {
        ForbiddenBook book1 = bookRepository.save(book);
        return book1;
    }

    public void delete(long id) {
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    public ForbiddenBook updateBook(ForbiddenBook book, long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
