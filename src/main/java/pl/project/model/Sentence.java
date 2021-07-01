package pl.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@XmlRootElement
public class Sentence {
    private String originalText;
    @XmlElement(name = "word")
    private List<String> wordList;

    public Sentence() {
        this.originalText = null;
        this.wordList = null;
    }

    public Sentence(String originalText) {
        this.originalText = originalText;
        this.wordList = null;
    }

    public List<String> getWordsList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public static boolean isValid(String originalText) {
        if (originalText.matches("[\\s]+") ||
                originalText.matches("")) {
            return false;
        }
        return true;
    }

    public void generate(String originalText) {
        this.originalText = originalText;
        this.wordList = sortWordList(splitSentenceIntoWords(prepareSentenceToSplit(originalText)));
    }

    String getOriginalText() {
        return originalText;
    }

    String prepareSentenceToSplit(String originalText) {
        String stepA = originalText.replaceAll("[’']+", ""); //delete apostrophes for english words
        String stepB = stepA.replaceAll("[-+*/,?><';\":\\]\\[}{|=_)(&^%$#@!`~]+", " "); //replace all non letter chars
        return stepB.replaceAll("\\\\", " ").replaceAll("[\\s]+", " "); //replace all unnecessary whitespaces
    }

    List<String> splitSentenceIntoWords(String preparedSentenceText) {
        String[] words = preparedSentenceText.split("[\\s]+");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        while (wordList.contains("") || wordList.contains(" ")) {
            wordList.remove("");
            wordList.remove(" ");
        }
        return wordList;
    }

    List<String> sortWordList(List<String> wordList) {
        wordList.sort(Collator.getInstance(Locale.ENGLISH));
        return wordList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        if (!originalText.equals(sentence.originalText)) return false;
        return wordList.equals(sentence.wordList);
    }

    @Override
    public int hashCode() {
        int result = originalText.hashCode();
        result = 31 * result + wordList.hashCode();
        return result;
    }
}
