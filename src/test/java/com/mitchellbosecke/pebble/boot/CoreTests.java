package com.mitchellbosecke.pebble.boot;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mitchellbosecke.pebble.PebbleEngine;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NonWebApplication.class)
public class CoreTests {

    @Autowired
    private PebbleEngine pebbleEngine;

    @Test
    public void testOk() throws Exception {
        StringWriter sw = new StringWriter();
        pebbleEngine.getTemplate("hello").evaluate(sw);
        Assert.assertTrue(sw.toString() != null && !sw.toString().isEmpty());
    }

}
