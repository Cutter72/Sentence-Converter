package pl.project.converter.csv;

import pl.project.converter.StreamWriterInterface;
import pl.project.model.Sentence;

import java.io.FileOutputStream;
import java.io.IOException;

public class CsvStreamWriterImpl implements StreamWriterInterface {
    private FileOutputStream fileOutputStream;
    private int sentenceCount;

    CsvStreamWriterImpl(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
        this.sentenceCount = 0;
    }

    void startDocument(int wordCount) {
        try {
            for (int i = 1; i <= wordCount; i++) {
                fileOutputStream.write((", Word " + i).getBytes());
            }
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSentence(Sentence sentence) {
        this.sentenceCount++;
        try {
            fileOutputStream.write(("Sentence " + this.sentenceCount).getBytes());
            for (String word : sentence.getWordsList()) {
                fileOutputStream.write((", " + word).getBytes());
            }
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
