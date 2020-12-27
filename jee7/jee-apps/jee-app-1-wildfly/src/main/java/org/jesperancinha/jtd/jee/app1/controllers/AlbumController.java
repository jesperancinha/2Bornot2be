package org.jesperancinha.jtd.jee.app1.controllers;

import org.jesperancinha.jtd.jee.app1.domain.Album;
import org.jesperancinha.jtd.jee.app1.domain.AlbumDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AlbumController {

    @Inject
    private AlbumDao albumDao;

    public List<Album> getAlbumList(){
       return albumDao.getAllAlbums();
    }

}
