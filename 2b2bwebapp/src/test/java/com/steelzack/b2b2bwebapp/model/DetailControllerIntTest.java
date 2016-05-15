package com.steelzack.b2b2bwebapp.model;

import com.steelzack.b2b2bwebapp.service.DetailController;
import com.steelzack.b2b2bwebapp.service.DetailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by joao on 15-5-16.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class DetailControllerIntTest {

    @Autowired
    DetailService detailService;

    @Autowired
    DetailController detailController;

    @Test
    public void findDetailById() throws Exception {
    }

}
