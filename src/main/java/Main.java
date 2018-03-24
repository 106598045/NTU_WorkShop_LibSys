import model.Book;
import model.LibraryRepository;

import java.util.List;

/**
 * Created by gunch on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId(1);
        book.setAuthor("林翰隆");
        book.setSubject("深度學習法");
        book.setIsCheck(true);
        book.setBorrower("戴碩宏");
        System.out.println(book.getBookId());
        System.out.println(book.getAuthor());
        System.out.println(book.getSubject());
        System.out.println(book.getIsCheck());
        System.out.println(book.getIsCheck());

        //測試add
        LibraryRepository.addBookToList(book);
        System.out.println(LibraryRepository.getCurrentId());

        //測試add已存在的書
        System.out.println(LibraryRepository.addBookToList(book));
        System.out.println(LibraryRepository.getCurrentId());

        //測試romove書
        LibraryRepository.romoveBookByList(book);
        System.out.println(LibraryRepository.getCurrentId());
        System.out.println(LibraryRepository.addBookToList(book));
        System.out.println(LibraryRepository.getCurrentId());

        //測試romove書
        System.out.println(LibraryRepository.romoveBookByList(book));
        System.out.println(LibraryRepository.getCurrentId());

        Book book2 = new Book();
        book2.setAuthor("林翰隆");
        book2.setSubject("深度學習法");
        book2.setIsCheck(false);
        book2.setBorrower("戴碩宏");

        Book book3 = new Book();
        book3.setAuthor("林翰隆");
        book3.setSubject("類神經網路");
        book3.setIsCheck(false);
        book3.setBorrower("戴碩宏");
        System.out.println(LibraryRepository.addBookToList(book2));
        System.out.println(LibraryRepository.addBookToList(book3));

        //測試checkout
        System.out.println("----------測試checkout-----------");
        book2.setBookId(LibraryRepository.getCurrentId());
        System.out.println("book checkout :"+LibraryRepository.checkoutBook(book2));
        System.out.println("book isCheck status:"+book2.getIsCheck());
        System.out.println("book get borrower:"+LibraryRepository.findBorrower(book2.getBookId()));

        //測試checkout已經被借走的書
        System.out.println("----------測試checkout已經被借走的書-----------");
        System.out.println("checkout of the checked out book : "+LibraryRepository.checkoutBook(book2));

        //測試getBookid 取得book
        System.out.println("----------測試getBookid-----------");
        System.out.println(""+LibraryRepository.findBookById(book2.getBookId()));
        System.out.println(""+LibraryRepository.findBookById(1)); //不存在的書
        System.out.println(""+LibraryRepository.findBookById(-1)); //當index為負

        //測試getBookByAuthor
        System.out.println("----------測試getBookByAuthor-----------");
        List<Book> bookList = LibraryRepository.findBookByAuthor("林翰隆");
        System.out.println(bookList.size());
        for(int i = 0;i < bookList.size();i++){
            System.out.println(bookList.get(i).getSubject());
        }

        //測試getBookByAuthor 無作者
        System.out.println("----------測試getBookByAuthor 無作者-----------");
        List<Book> bookList1_1 = LibraryRepository.findBookByAuthor("周志學");
        System.out.println(bookList1_1.size());
        for(int i = 0;i < bookList1_1.size();i++){
            System.out.println(bookList1_1.get(i).getSubject());
        }

        //測試getBookBySubject
        System.out.println("----------測試getBookBySubject-----------");
        List<Book> bookList2 = LibraryRepository.findBookBySubject("類神經網路");
        System.out.println(bookList2.size());
        for(int i = 0;i < bookList2.size();i++){
            System.out.println(bookList2.get(i).getSubject());
        }

        //測試getBookBySubject 無此subject
        System.out.println("----------測試getBookBySubject 無此subject-----------");
        List<Book> bookList2_2 = LibraryRepository.findBookBySubject("人工智慧");
        System.out.println(bookList2_2.size());
        for(int i = 0;i < bookList2_2.size();i++){
            System.out.println(bookList2_2.get(i).getSubject());
        }

        //測試findBookByBorrower
        System.out.println("----------測試findBookByBorrower-----------");
        List<Book> bookList3 = LibraryRepository.findBookByBorrower("戴碩宏");
        System.out.println(bookList3.size());
        for(int i = 0;i < bookList3.size();i++){
            System.out.println(bookList3.get(i).getSubject());
        }

        //測試findBookByBorrower 無作者
        System.out.println("----------測試findBookByBorrower 無此Borrower-----------");
        List<Book> bookList3_3 = LibraryRepository.findBookByBorrower("周志學");
        System.out.println(bookList3_3.size());
        for(int i = 0;i < bookList3_3.size();i++){
            System.out.println(bookList3_3.get(i).getSubject());
        }

        /*User user = new Borrower();
        user.checkoutBook();*/

    }
}
