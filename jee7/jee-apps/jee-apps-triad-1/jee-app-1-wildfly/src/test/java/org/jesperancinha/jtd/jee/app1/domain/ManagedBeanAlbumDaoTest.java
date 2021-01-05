package org.jesperancinha.jtd.jee.app1.domain;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jesperancinha.console.consolerizer.ConColor;
import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.app1.Resources;
import org.jesperancinha.jtd.jee.app1.data.ArtistProducer;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ManagedBeanAlbumDaoTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(Album.class, ManagedBeanAlbumDao.class, Resources.class, ArtistProducer.class, AlbumDao.class,
                UserTransaction.class, EntityManager.class, Consolerizer.class, ConColor.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    ManagedBeanAlbumDao managedBeanAlbumDao;

    @Test
    public void testCreateAlbum() {
        Album album = new Album();
        album.setAlbumName("Healing Is Difficult");
        album.setArtist("Sia");
        album.setYear(2001L);
        managedBeanAlbumDao.createAlbum(album);
        assertNotNull(album.getId());
        Consolerizer.printBrightCyanGenericLn("TEST-> %s", album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenNullYear_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setYear(null);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenEmailFail_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setEmail("Sia#wrongemail.com");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenSalesFail_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setSales("123.1234");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test
    public void testCreateAlbum_whenSalesGood_dontThrow() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setSales("123.12");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
        Consolerizer.printBrightCyanGenericLn("TEST-> %s", album);
    }

    @AfterClass
    public static void afterAll() {
        printBlueGenericTitleLn("After test ManagedBeanAlbumDaoTest");
        printGreenGenericLn("We see a lot of validations here in a layer above the database:");
        printGreenGenericLn("@Null, @NotNull, @Size, @Email and @Digits");
        printGreenGenericLn("@Null - Means explicitly that the member must be null");
        printGreenGenericLn("@NotNull - Means that the member cannot be null");
        printGreenGenericLn("@Size - Means that the member has to match validation in length");
        printGreenGenericLn("@Email - Means that the member has to have a conventional email form");
        printGreenGenericLn("@Digit - Is specific to numbers in a String form. It can be seen as an extension @Size");
        printGreenGenericLn(
            "More about @Digit: https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/Digits.html");
        printGreenGenericLn("BigDecimal\n" + "BigInteger\n" + "CharSequence\n"
            + "byte, short, int, long, and their respective wrapper types");
    }

}
