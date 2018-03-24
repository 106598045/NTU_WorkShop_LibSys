package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gunch on 2018/3/24.
 */
public class LibraryRepository {
    private static List<Book> bookList;
    private static int currentId;
    //如果false代表lib已存在相同subject
    public static  boolean addBookToList(Book book){
        boolean existbook = existBook(book.getSubject());
        if(!existbook){
            book.setBookId(currentId++);
            bookList.add(book);
        }
        return existbook;
    }
    //如果為false則代表不存在該book，problem:如果book被借走還可以remove嗎?
    public static boolean romoveBookByList(Book book){
        boolean existbook = existBook(book.getSubject());
        if(existbook)
            bookList.add(book);
        return existbook;
    }

    //如果book以借出或不存在則false
    public static boolean checkoutBook(Book book){
        boolean res = false;
        int bookid = book.getBookId();
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBookId() == bookid) {
                if(!bookList.get(i).getIsCheck()){
                    bookList.get(i).setIsCheck(true);
                    res = true;
                }
            }
        }
        return res;
    }

    public static boolean returnBook(Book book){
        boolean res = false;
        int bookid = book.getBookId();
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBookId() == bookid) {
                if(!bookList.get(i).getIsCheck()){
                    bookList.get(i).setIsCheck(false);
                    res = true;
                }
            }
        }
        return res;
    }


    public static Book findBookById(int id){
        Book book = null;
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBookId() == id)
                book = bookList.get(i);
        }
        return book;
    }

    //如果回傳null則代表不存在該作者
    public static List<Book> findBookByAuthor(String author){
        List<Book> list = new ArrayList<Book>();
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getAuthor() == author)
                list.add(bookList.get(i));
        }
        return list;
    }

    public static List<Book> findBookBySubject(String subject){
        List<Book> list = new ArrayList<Book>();
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getSubject() == subject)
                list.add(bookList.get(i));
        }
        return list;
    }

    public static List<Book> findBookByBorrower(String borrower){
        List<Book> list = new ArrayList<Book>();
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBorrower() == borrower)
                list.add(bookList.get(i));
        }
        return list;
    }
    //null代表沒有被借出
    public static String findBorrower(int id){
        Book book = null;
        if(isCheckedOut(id)){
            book = findBookById(id);
        }
        return book.getBorrower();
    }

    public static int getCurrentId(){
        return currentId;
    }

    private static boolean existBook(String subject){
        boolean res = false;
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getSubject() == subject)
                res = true;
        }
        return res;
    }

    private static boolean isCheckedOut(int id){
        boolean res = false;
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBookId() == id) {
                if(bookList.get(i).getIsCheck())
                    res = true;
            }
        }
        return res;
    }
}