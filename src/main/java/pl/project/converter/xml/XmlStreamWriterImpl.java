package pl.project.converter.xml;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import pl.project.converter.StreamWriterInterface;
import pl.project.model.Sentence;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;

class XmlStreamWriterImpl implements StreamWriterInterface {
    private FileOutputStream fileOutputStream;
    private Marshaller marshaller;

    XmlStreamWriterImpl(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Sentence.class);
            this.marshaller = jaxbContext.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            CharacterEscapeHandler escapeHandler = new XmlCharacterEscapeHandler();
            this.marshaller.setProperty("com.sun.xml.bind.characterEscapeHandler", escapeHandler);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    void startDocument() {
        try {
            fileOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<oryginalText>\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSentence(Sentence sentence) {
        try {
            this.marshaller.marshal(sentence, this.fileOutputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            this.fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeDocument() {
        try {
            this.fileOutputStream.write("</oryginalText>".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
