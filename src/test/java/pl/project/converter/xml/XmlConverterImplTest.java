package pl.project.converter.xml;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class XmlConverterImplTest {

    @Test
    public void convert() {
        //given
        XmlConverterImpl xmlConverterImpl = new XmlConverterImpl();
        Path inputFile = Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath();
        Path outputFile = Paths.get("src/main/resources/test_data/small.xml").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/sample_data/small.xml").toAbsolutePath();
        StringBuffer expected = new StringBuffer();
        try {
            Scanner scanner = new Scanner(expectedFile);
            while (scanner.hasNextLine()) {
                expected.append(scanner.nextLine());
                expected.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlConverterImpl.convert(inputFile.toFile(), outputFile.toFile());
        StringBuffer actual = new StringBuffer();
        try {
            Scanner scanner = new Scanner(outputFile);
            while (scanner.hasNextLine()) {
                actual.append(scanner.nextLine());
                actual.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected.toString(), actual.toString());
    }
}