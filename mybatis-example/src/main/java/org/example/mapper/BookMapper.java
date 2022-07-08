package org.example.mapper;

import org.example.pojo.Book;

import java.util.List;

public interface BookMapper {

    public List<Book> selectBookList();

    public int insert(Book book);
}
