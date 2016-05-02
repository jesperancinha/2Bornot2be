package com.steelzack.b2b2java8.caching;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */
public class VideoServiceImplTest {

    final Logger log = LoggerFactory.getLogger(VideoServiceImplTest.class);

    @Test
    public void findByDirector() throws Exception {

        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final VideoService videoService = (VideoService) context.getBean("videoService");

        log.info("Result : {}", videoService.findByAlbum("dummy"));
        log.info("Result : {}", videoService.findByAlbum("dummy"));
        log.info("Result : {}", videoService.findByAlbum("dummy"));

        //shut down the Spring context.
        ((ConfigurableApplicationContext) context).close();


    }

}