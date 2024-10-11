import org.example.Moduuli8.Moduuli8_1.StringManipulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    @Test
    void canConcatenate(){
        StringManipulator s = new StringManipulator();
        assertEquals("sumpitpihisee",s.concatenate("sumpit","pihisee"));
        assertNotEquals("sumpitpihisee",s.concatenate("vesi","kulho"));
    }

    @Test
    void canFindLength(){
        StringManipulator s = new StringManipulator();
        assertEquals(3,s.findLength("moi"));
        assertEquals(5,s.findLength("asdas"));
        assertNotEquals(2,s.findLength("asdasd"));
    }
    @Test
    void canConvertToUpperCase(){
        StringManipulator s = new StringManipulator();

        assertEquals("MOIMOI",s.convertToUpperCase("moimoi"));
        assertNotEquals("moimoi",s.convertToUpperCase("moimoi"));
    }
    @Test
    void canConvertToLowerCase(){
        StringManipulator s = new StringManipulator();

        assertEquals("moimoi",s.convertToLowerCase("MOIMOI"));
        assertNotEquals("MOIMOI",s.convertToLowerCase("MOIMOI"));

    }

    @Test
    void canFindSubString(){
        StringManipulator s = new StringManipulator();

        assertTrue(s.containsSubstring("pasikuikka", "kuikka"));
        assertFalse(s.containsSubstring("pasikuikka","asd"));
    }

}