import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ListToMapAdapter;

public class testListToMapAdapter {

    List<String> normalList;
    ListToMapAdapter adapter;

    @BeforeEach
    public void setUp(){

        normalList = new ArrayList<>();
        normalList.add("Elemento 1");
        normalList.add("Elemento 2");
        normalList.add("Elemento 3");

        adapter = new ListToMapAdapter<>(normalList);

    }

    @Test
    public void testClear(){

        assertEquals(3, adapter.size());
        adapter.clear();
        assertEquals(0, adapter.size());

    }

    @Test
    public void TestContainsKey() {

        assertEquals(true, adapter.containsKey(0));
        assertEquals(true, adapter.containsKey(1));
        assertEquals(true, adapter.containsKey(2));

        assertEquals(false, adapter.containsKey(3));
        assertEquals(false, adapter.containsKey(-1));
    
    }

    @Test
    public void TestContainsValue(){

        assertEquals(true, adapter.containsValue("Elemento 1"));
        assertEquals(true, adapter.containsValue("Elemento 2"));
        assertEquals(true, adapter.containsValue("Elemento 3"));

        assertEquals(false, adapter.containsValue(0));
        assertEquals(false, adapter.containsValue(-1));

    }

    @Test
    public void testEquals() {

        List<String> sameList = new ArrayList<>(normalList);
        ListToMapAdapter<Integer, String> sameAdapter = new ListToMapAdapter<>(sameList);
    
        assertTrue(adapter.equals(sameAdapter));
    
        List<String> differentList = new ArrayList<>();
        differentList.add("Elemento 4");
        ListToMapAdapter<Integer, String> differentAdapter = new ListToMapAdapter<>(differentList);
        
        assertFalse(adapter.equals(differentAdapter));
        assertFalse(adapter.equals(differentList));
    
        assertFalse(adapter.equals(null));
        assertFalse(adapter.equals("Não é um adaptador de map"));
    }
    
    @Test
    public void testGet(){
        int indexObjectInList1 = normalList.indexOf("Elemento 1");
        int indexObjectInList2 = normalList.indexOf("Elemento 2");
        int indexObjectInList3 = normalList.indexOf("Elemento 3");

        assertEquals("Elemento 1", adapter.get(indexObjectInList1));
        assertEquals("Elemento 2", adapter.get(indexObjectInList2));
        assertEquals("Elemento 3", adapter.get(indexObjectInList3));

    }

    @Test
    public void testIsEmpty(){

        assertFalse(adapter.isEmpty());

        adapter.clear();

        assertTrue(adapter.isEmpty());

    }

    @Test
    public void testPut(){

        assertFalse(adapter.containsValue("Elemento 4"));
        assertFalse(adapter.containsKey(3));

        adapter.put(3, "Elemento 4");

        assertTrue(adapter.containsValue("Elemento 4"));
        assertTrue(adapter.containsKey(3));

    }

    @Test
    public void testRemove(){

        assertTrue(adapter.containsValue("Elemento 3"));
        assertTrue(adapter.containsKey(2));

        adapter.remove(2);

        assertFalse(adapter.containsValue("Elemento 3"));
        assertFalse(adapter.containsKey(2));

    }
    
   @Test
    public void testSize() {

        assertEquals(3, adapter.size());

        adapter.put(3, "Elemento 4");
        assertEquals(4, adapter.size());

        adapter.clear();
        assertEquals(0, adapter.size());

    }

    @Test
    public void testValues() {

        Collection<String> values = adapter.values();
        
        assertTrue(values.contains("Elemento 1"));
        assertTrue(values.contains("Elemento 2"));
        assertTrue(values.contains("Elemento 3"));
        assertEquals(3, values.size());

        adapter.put(0, "Elemento Atualizado");
        assertTrue(values.contains("Elemento Atualizado"));
        assertFalse(values.contains("Elemento 1"));

    }

}
