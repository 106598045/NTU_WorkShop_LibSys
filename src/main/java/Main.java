import model.Book;
import model.LibraryRepository;

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
        book2.setIsCheck(true);
        book2.setBorrower("戴碩宏");

        //測試romove書
        System.out.println(LibraryRepository.addBookToList(book2));
        book2.setBookId(LibraryRepository.getCurrentId());
        System.out.println(LibraryRepository.checkoutBook(book2));
        System.out.println(LibraryRepository.findBorrower(book2.getBookId()));
    }
}
