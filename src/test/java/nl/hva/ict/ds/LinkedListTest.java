package nl.hva.ict.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    protected LinkedList<String> testList;

    @Before
    public void setup() {
        testList = new LinkedList<>();
    }

    @Test
    public void addToEmptyList() {
        testList.add("one");

        assertTrue(testList.size() != 0);
        assertEquals("one", testList.get(0));
        
    }

    @Test
    public void addToListWithOneElement() {
        testList.add("one");
        testList.add("two");

        assertTrue(testList.size() != 0);
        assertEquals("two", testList.get(1));
    }

    @Test
    public void getFirstElement() {
        testList.add("one");

        assertEquals("one", testList.get(0));
    }

    @Test
    public void getLastElement() {
        testList.add("one");
        testList.add("two");

        assertEquals("two", testList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexIsNotAllowed() {
        testList.get(-1);
    }

    @Test
    public void deleteFromListWithSingleElement() {
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }

    @Test
    public void deleteFromListWithMultipleOccurences() {
        testList.add("one");
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }

    @Test
    public void deleteFromListWithMultipleOccurrencesAndMoreElements() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        testList.delete("one");

        assertEquals(1, testList.size());
    }

    @Test
    public void sizeOfEmptyList() {
        assertEquals(0, testList.size());
    }

    @Test
    public void sizeOfListWithOneElement() {
        testList.add("one");
        assertEquals(1, testList.size());
    }

    // Extra unit tests go here
      
    @Test(expected = IllegalArgumentException.class)
    public void getFromEmptyList() {
       testList.get(5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getNegativeIndex() {
        testList.get(-5);
    }
    
    @Test
    public void deleteNonExistingElement() {
        testList.add("one");
        testList.delete("two");
    }
    
    @Test
    public void getSizeFromList() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        
        testList.delete("one");
        
        assertEquals(1, testList.size());
        
    }
    
    @Test
    public void getElementValues() {
        testList.add("test");
        testList.add("test!");

        assertEquals("test", testList.get(0));
        assertEquals("test!", testList.get(1));

    }
    
    @Test
    public void addManyElements() {
        int number = 100;
        
        for(int i = 0; i < number; i++) {
            testList.add("element" + i);
        }
        
        assertEquals(number, testList.size());    
    }
    
    @Test
    public void addManyElementsAndGetValue() {
        int number = 100;
        
        for(int i = 0; i < number; i++) {
            testList.add("element" + i);
        }
        
        assertEquals("element50", testList.get(50));    
    }

}
