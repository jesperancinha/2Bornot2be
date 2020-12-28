package org.jesperancinha.jtd.jee.app1.controllers;

import org.jesperancinha.jtd.jee.app1.domain.Album;
import org.jesperancinha.jtd.jee.app1.domain.AlbumDao;
import org.jesperancinha.jtd.jee.app1.domain.EJBAlbumDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefault;

@Named
@RequestScoped
public class AlbumController {

    @Inject
    private AlbumDao albumDao;

    @Produces
    @Named
    private Album newAlbum;

    public List<Album> getAlbumList() {
        setupFastDefault();
        printYellowGenericLn("The album list has been called!");
        return albumDao.getAllAlbums();
    }

    public void createAlbum() {
        setupFastDefault();
        printYellowGenericLn("The album %s is going to be created!", newAlbum);
        albumDao.createAlbum(newAlbum);
    }

    @PostConstruct
    public void initNewMember() {
        newAlbum = new Album();
    }

}
