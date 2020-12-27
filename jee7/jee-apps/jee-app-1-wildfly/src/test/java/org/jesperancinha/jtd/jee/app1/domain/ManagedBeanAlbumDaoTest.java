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
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ManagedBeanAlbumDaoTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(Album.class,
                ManagedBeanAlbumDao.class,
                Resources.class,
                AlbumDao.class, UserTransaction.class, EntityManager.class,
                Consolerizer.class, ConColor.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE,  "beans.xml")
            .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    ManagedBeanAlbumDao managedBeanAlbumDao;

    @Test
    public void testcreateAlbum() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
        assertNotNull(album.getId());
        Consolerizer.printBrightCyanGenericLn("TEST->", album);
    }

}
