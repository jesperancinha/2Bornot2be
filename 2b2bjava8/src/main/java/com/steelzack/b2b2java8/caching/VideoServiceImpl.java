package com.steelzack.b2b2java8.caching;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */
public class VideoServiceImpl implements VideoService{

    //This "movieFindCache" is delcares in ehcache.xml
    @Cacheable(value="movieFindCache", key="#name")
    public Movie findByDirector(String name) {
        slowQuery(2000L);
        System.out.println("findByDirector is running...");
        return new Movie(1,"Forrest Gump","Robert Zemeckis");
    }

    private void slowQuery(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

} {
}
