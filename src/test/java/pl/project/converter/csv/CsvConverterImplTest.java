package pl.project.converter.csv;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class CsvConverterImplTest {

    @Test
    public void convert() {
        //given
        CsvConverterImpl csvConverterImpl = new CsvConverterImpl();
        Path inputFile = Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath();
        Path outputFile = Paths.get("src/main/resources/test_data/small.csv").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/sample_data/small.csv").toAbsolutePath();
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
        csvConverterImpl.convert(inputFile.toFile(), outputFile.toFile());
        StringBuffer actual = new StringBuffer();
        try {
            Scanner scanner = new Scanner(expectedFile);
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