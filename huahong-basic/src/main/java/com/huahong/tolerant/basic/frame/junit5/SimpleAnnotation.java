package com.huahong.tolerant.basic.frame.junit5;


import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * File：SimpleAnnotation <br>
 * Created on 2020/1/30.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */

@DisplayName("Testing using JUnit 5")
public class SimpleAnnotation {
    private static final Logger log = LoggerFactory.getLogger(SimpleAnnotation.class);

    @Test
    @BeforeAll
    public static void init(){
        System.out.println("before all display");
    }

    @Test
    @AfterAll
    public static void done(){
        System.out.println("before all display");
    }


    @Test
    @DisplayName("Dummy test")
    void aTest() {
        log.info("As written, this test will always pass!");
        assertEquals(4, (2 + 2));
    }

    @Test
    @Disabled
    @DisplayName("A disabled test")
    void testNotRun() {
        log.info("This test will not run (it is disabled, silly).");
    }
}
