import model.Book;
import model.LibraryRepository;

/**
 * Created by gunch on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("林翰隆");
        book.setSubject("深度學習法");
        LibraryRepository.addBookToList(book);
        System.out.println();
    }
}
