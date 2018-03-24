package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gunch on 2018/3/25.
 */
public class BookTest {
    @Test
    public void setBookId() throws Exception {
        Book book = new Book();
        book.setBookId(1);
        assertEquals(1,book.getBookId());
    }

    @Test
    public void setAuthor() throws Exception {
        Book book = new Book();
        book.setAuthor("123");
        assertEquals("123",book.getAuthor());
    }

    @Test
    public void setAuthorEmptyOrNull() throws Exception {
        Book book = new Book();
        book.setAuthor("");
        assertEquals("",book.getAuthor());
        book.setAuthor(null);
        assertEquals(null,book.getAuthor());
    }

    @Test
    public void setSubject() throws Exception {
        Book book = new Book();
        book.setSubject("software arch");
        assertEquals("software arch",book.getSubject());
    }

    @Test
    public void setSubjectEmptyOrNull() throws Exception {
        Book book = new Book();
        book.setSubject("");
        assertEquals("",book.getSubject());
        book.setSubject(null);
        assertEquals(null,book.getSubject());
    }

    @Test
    public void setIsCheck() throws Exception {
        Book book = new Book();
        book.setIsCheck(true);
        assertEquals(true,book.getIsCheck());
    }

    @Test
    public void setBorrower() throws Exception {
        Book book = new Book();
        book.setBorrower("tom");
        assertEquals("tom",book.getBorrower());
    }

}