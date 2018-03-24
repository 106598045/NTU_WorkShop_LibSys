package model;

import java.util.List;

/**
 * Created by gunch on 2018/3/24.
 */
public class LibraryRepository {
    private List<Book> bookList;
    private int currentId;
    //如果false代表lib已存在相同subject
    public boolean addBookToList(Book book){
        boolean existbook = existBook(book.getSubject());
        if(!existbook){
            book.setBookId(currentId++);
            bookList.add(book);
        }
        return existbook;
    }
    //如果為false則代表不存在該book，problem:如果book被借走還可以remove嗎?
    public boolean romoveBookByList(Book book){
        boolean existbook = existBook(book.getSubject());
        if(existbook)
            bookList.add(book);
        return existbook;
    }

    //未完成
    public boolean checkoutBook(Book book){
        boolean isCheckOut = isCheckedOut(book.getBookId());

        return isCheckOut;
    }

    public Book findBookById(int id){
        Book book = null;
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getBookId() == id)
                book = bookList.get(i);
        }
        return book;
    }
    private boolean existBook(String subject){
        boolean res = false;
        for(int i = 0; i <= bookList.size();i++){
            if(bookList.get(i).getSubject() == subject)
                res = true;
        }
        return res;
    }

    private boolean isCheckedOut(int id){
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
