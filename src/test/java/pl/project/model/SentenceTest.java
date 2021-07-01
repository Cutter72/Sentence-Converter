package pl.project.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {

    @Test
    public void prepareSentenceToSplit() {
        //given
        String expectedSentenceTextA = "Mary had a little lamb ";
        String expectedSentenceTextB = " Peter called for the wolf and Aesop came ";
        String expectedSentenceTextC = " Cinderella likes shoes ";
        String expectedSentenceTextD = "in In in ";

        String givenSentenceTextA = "Mary had a little lamb .\n";
        String givenSentenceTextB = "    \n Peter called for the wolf , and Aesop came .\n";
        String givenSentenceTextC = "    Cinderella likes shoes...";
        String givenSentenceTextD = "in In in.";
        Sentence sentenceA = new Sentence(givenSentenceTextA);
        Sentence sentenceB = new Sentence(givenSentenceTextB);
        Sentence sentenceC = new Sentence(givenSentenceTextC);
        Sentence sentenceD = new Sentence(givenSentenceTextD);
        //when
        String actualA = sentenceA.prepareSentenceToSplit(sentenceA.getOriginalText());
        String actualB = sentenceB.prepareSentenceToSplit(sentenceB.getOriginalText());
        String actualC = sentenceC.prepareSentenceToSplit(sentenceC.getOriginalText());
        String actualD = sentenceD.prepareSentenceToSplit(sentenceD.getOriginalText());
        //then
        assertEquals(expectedSentenceTextA, actualA);
        assertEquals(expectedSentenceTextB, actualB);
        assertEquals(expectedSentenceTextC, actualC);
        assertEquals(expectedSentenceTextD, actualD);
    }

    @Test
    public void splitSentenceIntoWords() {
        //given
        List<String> expectedA = new ArrayList<>();
        expectedA.add("Mary");
        expectedA.add("had");
        expectedA.add("a");
        expectedA.add("little");
        expectedA.add("lamb");
        List<String> expectedB = new ArrayList<>();
        expectedB.add("Peter");
        expectedB.add("called");
        expectedB.add("for");
        expectedB.add("the");
        expectedB.add("wolf");
        expectedB.add("and");
        expectedB.add("Aesop");
        expectedB.add("came");
        List<String> expectedC = new ArrayList<>();
        expectedC.add("Cinderella");
        expectedC.add("likes");
        expectedC.add("shoes");
        List<String> expectedD = new ArrayList<>();
        expectedD.add("in");
        expectedD.add("In");
        expectedD.add("in");
        String preparedSentenceTextA = "Mary had a little lamb   ";
        String preparedSentenceTextB = "      Peter called for the wolf   and Aesop came   ";
        String preparedSentenceTextC = "    Cinderella likes shoes   ";
        String preparedSentenceTextD = "in In in ";
        Sentence sentenceA = new Sentence();
        Sentence sentenceB = new Sentence();
        Sentence sentenceC = new Sentence();
        Sentence sentenceD = new Sentence();
        //when
        List<String> actualA = sentenceA.splitSentenceIntoWords(preparedSentenceTextA);
        List<String> actualB = sentenceB.splitSentenceIntoWords(preparedSentenceTextB);
        List<String> actualC = sentenceC.splitSentenceIntoWords(preparedSentenceTextC);
        List<String> actualD = sentenceD.splitSentenceIntoWords(preparedSentenceTextD);
        //then
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
        assertEquals(expectedC, actualC);
        assertEquals(expectedD, actualD);
    }

    @Test
    public void sortWordList() {
        //given
        List<String> unsortedA = new ArrayList<>();
        unsortedA.add("Mary");
        unsortedA.add("had");
        unsortedA.add("a");
        unsortedA.add("little");
        unsortedA.add("lamb");
        List<String> unsortedB = new ArrayList<>();
        unsortedB.add("Peter");
        unsortedB.add("called");
        unsortedB.add("for");
        unsortedB.add("the");
        unsortedB.add("wolf");
        unsortedB.add("and");
        unsortedB.add("Aesop");
        unsortedB.add("came");
        List<String> unsortedC = new ArrayList<>();
        unsortedC.add("Cinderella");
        unsortedC.add("likes");
        unsortedC.add("shoes");
        List<String> unsortedD = new ArrayList<>();
        unsortedD.add("in");
        unsortedD.add("In");
        unsortedD.add("in");


        List<String> expectedA = new ArrayList<>();
        expectedA.add("a");
        expectedA.add("had");
        expectedA.add("lamb");
        expectedA.add("little");
        expectedA.add("Mary");
        List<String> expectedB = new ArrayList<>();
        expectedB.add("Aesop");
        expectedB.add("and");
        expectedB.add("called");
        expectedB.add("came");
        expectedB.add("for");
        expectedB.add("Peter");
        expectedB.add("the");
        expectedB.add("wolf");
        List<String> expectedC = new ArrayList<>();
        expectedC.add("Cinderella");
        expectedC.add("likes");
        expectedC.add("shoes");
        List<String> expectedD = new ArrayList<>();
        expectedD.add("in");
        expectedD.add("in");
        expectedD.add("In");
        Sentence sentenceA = new Sentence();
        Sentence sentenceB = new Sentence();
        Sentence sentenceC = new Sentence();
        Sentence sentenceD = new Sentence();
        //when
        List<String> actualA = sentenceA.sortWordList(unsortedA);
        List<String> actualB = sentenceB.sortWordList(unsortedB);
        List<String> actualC = sentenceC.sortWordList(unsortedC);
        List<String> actualD = sentenceD.sortWordList(unsortedD);
        //then
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
        assertEquals(expectedC, actualC);
        assertEquals(expectedD, actualD);
    }

    @Test
    public void isValid() {
        //given
        String sentenceToCheckA = "";
        String sentenceToCheckB = "  \n \r \r\n \t  ";
        String sentenceToCheckC = "Mr. and \r\n" +
                "Ms. Smith \r\n" +
                "met Dr. Jekyll \r\n" +
                "outside";
        String sentenceToCheckD = "    \n Peter called for the wolf , and Aesop came .\n";
        //when
        boolean actualA = Sentence.isValid(sentenceToCheckA);
        boolean actualB = Sentence.isValid(sentenceToCheckB);
        boolean actualC = Sentence.isValid(sentenceToCheckC);
        boolean actualD = Sentence.isValid(sentenceToCheckD);
        //then
        assertFalse(actualA);
        assertFalse(actualB);
        assertTrue(actualC);
        assertTrue(actualD);
    }

    @Test
    public void prepareSentence() {
        //given
        Sentence sentence = new Sentence();
        String sentenceText = "I couldn't understand a word,perhaps because Chinese \n" +
                " isn't my mother tongue";
        List<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("because");
        expected.add("Chinese");
        expected.add("couldnt");
        expected.add("I");
        expected.add("isnt");
        expected.add("mother");
        expected.add("my");
        expected.add("perhaps");
        expected.add("tongue");
        expected.add("understand");
        expected.add("word");
        //when
        sentence.generate(sentenceText);
        //then
        assertEquals(sentenceText, sentence.getOriginalText());
        assertEquals(expected, sentence.getWordsList());
    }
}