package ts.ion.example.textwriter.sids;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WriteAnnotationsThatIsASidTest {

    @Test
    public void testSimpleString() throws IOException {
        String s = "simple text";
        WriteAnnotationsThatIsAsSid wa = new WriteAnnotationsThatIsAsSid(s);
        assertEquals("\""+ s + "\"", wa.doIt());
    }

    @Test
    public void testSimpleAnnotation() throws IOException {
        String s = "simple text";
        String a = "bar";
        WriteAnnotationsThatIsAsSid wa = new WriteAnnotationsThatIsAsSid(s);
        wa.setAnnotation(a);
        assertEquals(a + "::\""+ s + "\"", wa.doIt());
    }


    @Test
    public void testAnnotationSID() throws IOException {
        String s = "simple text";
        String a = "$1";
        WriteAnnotationsThatIsAsSid wa = new WriteAnnotationsThatIsAsSid(s);
        wa.setAnnotation(a);
        assertEquals("\'" + a  + "\'" + "::\""+ s + "\"", wa.doIt());
    }
}