/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1151117.contactstags.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Barros
 */
public class TagTest {
    
    private Tag tag;
    
    public TagTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tag = new Tag("teste");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = IllegalStateException.class)
    public void testTagValueMustNotBeNull(){
        tag = new Tag(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testTagValueMustNotBeEmpty(){
        tag = new Tag("");
    }
    
    @Test(expected = IllegalStateException.class)
    public void testTagValueMustNotBeWhiteSpace(){
        tag = new Tag("  ");
    }
    
    @Test(expected = IllegalStateException.class)
    public void testTagValueMustContainWhiteSpaces(){
        Tag t = new Tag("teste tag");
    }
    
    @Test
    public void testTagValueIsValid(){
        tag = new Tag("teste");
    }

    /**
     * Test of tagValue method, of class Tag.
     */
    @Test
    public void testTagValue() {
        System.out.println("tagValue");
        assertEquals("teste", tag.tagValue());
    }
    
}
