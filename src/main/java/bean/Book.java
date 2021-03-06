package bean;

/**
 * Created by gunch on 2018/3/24.
 */
public class Book {
    private int bookId;
    private String author;
    private String subject;
    private boolean isCheck;
    private String borrower;

    public Book(){
        isCheck = false;
    }

    public void setBookId(int id){
        this.bookId = id;
    }

    public int getBookId(){
        return this.bookId;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

    public void setIsCheck(boolean isCheck){
        this.isCheck = isCheck;
    }

    public boolean getIsCheck(){
        return isCheck;
    }

    public void setBorrower(String borrower){
        this.borrower = borrower;
    }

    public String getBorrower(){
        return this.borrower;
    }
}
