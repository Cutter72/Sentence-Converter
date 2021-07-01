package pl.project.converter;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void findMaxNumberOfWordsInSentence() {
        //given
        Path inputFile = Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath();
        //when
        WordCounter wordCounter = new WordCounter();
        int actual = wordCounter.findMaxNumberOfWordsInSentence(inputFile.toFile());
        //then
        assertEquals(17, actual);
    }
}