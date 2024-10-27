import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.MapToListAdapter;

public class testMapToListAdapter {
    
    MapToListAdapter adapter;

    @BeforeEach
    public void setUp(){

        adapter = new MapToListAdapter<>();
        
    }

    @Test
    public void testAddAndSize(){

        assertEquals(0, adapter.size());

        assertTrue(adapter.add("Elemento 0"));
        assertTrue(adapter.add("Elemento 1"));
        assertTrue(adapter.add("Elemento 2"));
        
        assertEquals(3, adapter.size());

    }

    @Test
    public void testClear(){

        assertEquals(0, adapter.size());

        assertTrue(adapter.add("Elemento 0"));
        assertTrue(adapter.add("Elemento 1"));
        
        assertEquals(2, adapter.size());

        adapter.clear();

        assertEquals(0, adapter.size());

    }

    @Test
    public void testContains(){

        adapter.add("Elemento 0");
        adapter.add("Elemento 1");

        assertTrue(adapter.contains("Elemento 0"));
        assertTrue(adapter.contains("Elemento 1"));
        assertFalse(adapter.contains("Elemento 2"));

    }

    @Test
    public void testEquals() {
        MapToListAdapter anotherAdapter = new MapToListAdapter<>();
    
        assertTrue(adapter.equals(anotherAdapter));
    
        adapter.add("Elemento 0");
        adapter.add("Elemento 1");
    
        anotherAdapter.add("Elemento 0");
        anotherAdapter.add("Elemento 1");
    
        assertTrue(adapter.equals(anotherAdapter));
    
        anotherAdapter.add("Elemento Diferente");
    
        assertFalse(adapter.equals(anotherAdapter));
    
        List<String> differentTypeObject = new ArrayList<>();
        assertFalse(adapter.equals(differentTypeObject));
    }
    
    @Test
    public void testGet(){

        adapter.add("Elemento 0");
        assertEquals("Elemento 0", adapter.get(0));
        assertNotEquals("Elemento1", adapter.get(0));

    }
    
    @Test
    public void testIsEmpty(){

        assertTrue(adapter.isEmpty());

        adapter.add("elemento 0");

        assertFalse(adapter.isEmpty());
            
    }

    @Test
    public void testIterator() {
        adapter.add("Elemento 0");
        adapter.add("Elemento 1");
        adapter.add("Elemento 2");

        Iterator<String> iterator = adapter.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Elemento 0", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Elemento 1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Elemento 2", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testRemove() {
        adapter.add("Elemento 0");
        adapter.add("Elemento 1");
        adapter.add("Elemento 2");

        assertTrue(adapter.remove("Elemento 1"));
        assertEquals(2, adapter.size());
        assertFalse(adapter.contains("Elemento 1"));

        assertEquals(2, adapter.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, adapter.size());

        adapter.add("Elemento 0");
        assertEquals(1, adapter.size());

        adapter.add("Elemento 1");
        adapter.add("Elemento 2");
        assertEquals(3, adapter.size());

        adapter.remove("Elemento 1");
        assertEquals(2, adapter.size());
    }

    @Test
    public void testToArray() {
        adapter.add("Elemento 0");
        adapter.add("Elemento 1");
        adapter.add("Elemento 2");

        Object[] array = adapter.toArray();

        assertEquals(3, array.length);
        assertEquals("Elemento 0", array[0]);
        assertEquals("Elemento 1", array[1]);
        assertEquals("Elemento 2", array[2]);
    }
}
