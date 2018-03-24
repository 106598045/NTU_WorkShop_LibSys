package model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


/**
 * Created by gunch on 2018/3/24.
 */
@RunWith(Arquillian.class)
public class BookTest {
    @org.junit.Test
    public void setBookId() throws Exception {
        Book book = new Book();
        book.setBookId(1);
        assertEquals(1,book.getBookId());
    }

    @org.junit.Test
    public void getBookId() throws Exception {
    }

    @org.junit.Test
    public void setAuthor() throws Exception {
    }

    @org.junit.Test
    public void getAuthor() throws Exception {
    }

    @org.junit.Test
    public void setSubject() throws Exception {
    }

    @org.junit.Test
    public void getSubject() throws Exception {
    }

    @org.junit.Test
    public void setIsCheck() throws Exception {
    }

    @org.junit.Test
    public void getIsCheck() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Book.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
