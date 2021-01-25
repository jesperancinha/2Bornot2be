package org.jesperancinha.jtd.jee.flash.flash1;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jesperancinha.jtd.jee.flash.FlashRunnerBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;

@RunWith(Arquillian.class)
@Ignore
public class FlashRunnerBeanTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(FlashRunnerBean.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void  testReminder(){
        BLUE.printGenericLn("WOW It works!");
    }
}
