package com.shuai.test.caching;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
