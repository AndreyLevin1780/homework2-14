package test;

import Impl.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringListImplTest {

    private final StringListImpl testStringListImpl = new StringListImpl(5);


    // private String[] expected = new String[5];

   // private String[] expected = {"1", "2", "3", "4", null};



    @Test
    public void sizeTest() {
        assertEquals(0, testStringListImpl.size());
    }

    @Test
    public void isEmptyTest() {
        assertTrue(testStringListImpl.isEmpty());
    }


    @Test
    public void getTest() {
        testStringListImpl.add(0, "1");
        assertEquals("1", testStringListImpl.get(0));
    }


    @Test
    public void addTest() {

        testStringListImpl.add(0, "1");
        assertEquals("1", testStringListImpl.add(0, "1"));
        System.out.println(testStringListImpl.get(0));
    }

}
