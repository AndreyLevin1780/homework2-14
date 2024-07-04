package test;

import Impl.StringListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.assertj.core.api.Assertions;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StringListImplTest {

    private final StringListImpl testStringListImpl = new StringListImpl(5);


    private final String[] testList = {"1", "2", "3", "4"};


    //@AfterEach
    //public void AfterEach() {
    //    employeeService.findAll().forEach(employee -> employeeService.remove(employee.getFirstName(), employee.getLastName()));
    //}

    @BeforeEach
    public void BeforeEach() {
        System.out.println(Arrays.toString(testList));
        for (int i = 0; i < testList.length; i++) {
            testStringListImpl.add(i, testList[i]);
        }
    }


    @Test
    public void sizeTest() {
        assertEquals(4, testStringListImpl.size());
    }

    @Test
    public void isEmptyTest() {
        assertFalse(testStringListImpl.isEmpty());
    }


    @Test
    public void getTest() {
        assertEquals("1", testStringListImpl.get(0));
    }


    @Test
    public void addTest() {
        assertEquals("5", testStringListImpl.add(4, "5"));
        System.out.println(testStringListImpl.get(4));
        assertTrue(testStringListImpl.contains("5"));
    }

    @Test
    public void removeTest() {
        testStringListImpl.remove(0);
        assertEquals(3, testStringListImpl.size());
        assertEquals("2", testStringListImpl.get(0));

    }

    @Test
    public void containsTest() {
        assertTrue(testStringListImpl.contains("1"));
    }

    @Test
    public void clearTest() {
        testStringListImpl.clear();
        assertTrue(testStringListImpl.isEmpty());
    }

    @Test
    public void indexOfTest() {
        assertEquals(1, testStringListImpl.indexOf("2"));
    }
}
