package pl.project.converter;

import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileSentenceIteratorTest {

    @Test
    public void hasNext() {
        //given
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(new File(Paths.get("src/main/resources/test_data/sentenceReadTest").toAbsolutePath().toString()));
        //when

        //then
        assertTrue(fileSentenceIterator.hasNext());
        fileSentenceIterator.next();
        assertTrue(fileSentenceIterator.hasNext());
        fileSentenceIterator.next();
        assertTrue(fileSentenceIterator.hasNext());
        fileSentenceIterator.next();
        assertFalse(fileSentenceIterator.hasNext());
    }

    @Test
    public void next() {
        //given
        String expected = "Mr. and \r\n" +
                "Ms. Smith \r\n" +
                "met Dr. Jekyll \r\n" +
                "outside";
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(new File(Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath().toString()));
        //when
        String actual = fileSentenceIterator.next();
        //then
        assertEquals(expected, actual);
    }
}