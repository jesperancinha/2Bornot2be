package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import com.steelzack.b2b2java8.configuration.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by joao on 14-5-16.
 */
@Configuration
@Import(Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PredicateMainTest {

    @Test
    public void doThePredicateMethod() throws Exception {

    }

}
