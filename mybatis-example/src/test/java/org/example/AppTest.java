package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BookMapper;
import org.example.pojo.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    SqlSessionFactory sqlSessionFactory;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectBookList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            List<Book> bookList = mapper.selectBookList();

            for (Book book:bookList) {
                System.out.println(book);
            }
        }
    }

    @Test
    public void testInsertBook() throws IOException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            Book book = new Book();
            book.setTitle("Java book");
            book.setAuthor("silas");
            book.setPrice(new BigDecimal(1.9));
            int res = mapper.insert(book);
            session.commit();
            System.out.println(String.format("insert result:%s",res));
            System.out.println(String.format("book.id:%s",book.getId()));

        }
    }
}
