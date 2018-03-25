package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gunch on 2018/3/25.
 */
public class LibraryRepositoryTest {
    @Test
    public void addBookToList() throws Exception {
        //沒有任何資訊
        Book book = new Book();
        assertEquals(false,LibraryRepository.addBookToList(book));

        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        assertEquals(true,LibraryRepository.addBookToList(book2));
    }

    @Test
    public void addBookToListWithoutAuthor() throws Exception {
        Book book = new Book();
        book.setSubject("深度學習法");
        assertEquals(false,LibraryRepository.addBookToList(book));
    }

    @Test
    public void addBookToListWithoutSubject() throws Exception {
        Book book = new Book();
        book.setAuthor("林翰隆");
        assertEquals(false,LibraryRepository.addBookToList(book));
    }

    @Test
    public void addBookToListExist() throws Exception {
        Book book = new Book();
        book.setAuthor("林翰隆");
        book.setSubject("深度學習法");
        assertEquals(true,LibraryRepository.addBookToList(book));
        Book book2 = new Book();
        book2.setAuthor("戴碩宏");
        book2.setSubject("深度學習法");
        assertEquals(false,LibraryRepository.addBookToList(book2));
    }

    @Test
    public void romoveBookByList() throws Exception {
        Book book = new Book();
        book.setAuthor("林翰隆");
        book.setSubject("深度學習法");
        //不同作者但相同書名會有bug
        /*Book book2 = new Book();
        book2.setAuthor("戴碩宏");
        book2.setSubject("深度學習法");*/
        Book book2 = new Book();
        book2.setAuthor("戴碩宏");
        book2.setSubject("類神經網路");


        assertEquals(true,LibraryRepository.addBookToList(book));
        //沒加入Lib 所以不存在
        assertEquals(false,LibraryRepository.romoveBookByList(book2));
        assertEquals(true,LibraryRepository.romoveBookByList(book));
    }

    @Test
    public void checkoutBook() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");

        Book book3 = new Book();
        book3.setAuthor("林翰隆");
        book3.setSubject("類神經網路");
        book3.setBorrower("戴碩宏");

        LibraryRepository.addBookToList(book2);
        LibraryRepository.addBookToList(book3);
        assertEquals(true,LibraryRepository.checkoutBook(book2));
        assertEquals(true,book2.getIsCheck());
    }

    @Test
    public void checkoutOfCheckedoutBook() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");

        LibraryRepository.addBookToList(book2);
        assertEquals(true,LibraryRepository.checkoutBook(book2));
        assertEquals(true,book2.getIsCheck());
        assertEquals(false,LibraryRepository.checkoutBook(book2));
    }

    @Test
    public void returnBook() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        book2.setBookId(0);
        assertEquals(true,LibraryRepository.checkoutBook(book2));
        assertEquals(true,book2.getIsCheck());
        assertEquals(true,LibraryRepository.returnBook(book2));
        assertEquals("", LibraryRepository.findBookById(0).getBorrower());
    }

    @Test
    public void returnBookNonCheckout() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        book2.setBookId(0);
        assertEquals(false,book2.getIsCheck());
        assertEquals(false,LibraryRepository.returnBook(book2));

    }

    @Test
    public void findBookById() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        assertEquals("深度學習法",LibraryRepository.findBookById(0).getSubject());

        assertEquals(null,LibraryRepository.findBookById(1));
    }

    @Test
    public void findBookByAuthor() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        assertEquals(1,LibraryRepository.findBookByAuthor("林翰隆").size());

        assertEquals(null,LibraryRepository.findBookByAuthor("周治學"));
    }

    @Test
    public void findBookBySubject() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        assertEquals(1,LibraryRepository.findBookBySubject("深度學習法").size());

        assertEquals(null,LibraryRepository.findBookBySubject("深度"));
    }

    @Test
    public void findBookByBorrower() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        assertEquals(1,LibraryRepository.findBookByBorrower("戴碩宏").size());

        assertEquals(null,LibraryRepository.findBookByBorrower("林翰隆"));
    }

    @Test
    public void findBorrower() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        LibraryRepository.checkoutBook(book2);
        assertEquals("戴碩宏",LibraryRepository.findBorrower(0));

        assertEquals(null,LibraryRepository.findBorrower(1));
    }

    @Test
    public void getCurrentId() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        assertEquals(1,LibraryRepository.getCurrentId());
    }

    @Test
    public void isCheckOut() throws Exception {
        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setBorrower("戴碩宏");
        LibraryRepository.addBookToList(book2);
        LibraryRepository.checkoutBook(book2);
        assertEquals(true,LibraryRepository.isCheckedOut(0));

    }

}