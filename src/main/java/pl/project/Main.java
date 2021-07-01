package pl.project;

import pl.project.converter.csv.CsvConverterImpl;
import pl.project.converter.xml.XmlConverterImpl;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static final String CMD_QUIT = "quit";
    private static final String CSV_SUFFIX = ".csv";
    private static final String XML_SUFFIX = ".xml";

    public static void main(String[] args) {
        System.out.println("Wpisz lub wklej ściężkę do pliku tekstowego który chcesz przekonvertować na XML i CSV. " +
                "Aby wyjść wpisz 'quit'.");
        String cmd;
        XmlConverterImpl xmlConverter = new XmlConverterImpl();
        CsvConverterImpl csvConverter = new CsvConverterImpl();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase(CMD_QUIT)) {
                break;
            }
            File fileToConvert = new File(cmd);
            if (fileToConvert.isFile()) {
                if (fileToConvert.canRead()) {
                    System.out.print("Naciśnij Enter aby rozpocząć konwersję...");
                    cmd = scanner.nextLine();
                    if (cmd.equalsIgnoreCase(CMD_QUIT)) {
                        System.out.print("Konwertowanie anulowane.");
                        break;
                    }
                    String fileToConvertAbsolutePath = fileToConvert.getAbsolutePath();
                    File outputXml = new File(fileToConvertAbsolutePath + XML_SUFFIX);
                    File outputCsv = new File(fileToConvertAbsolutePath + CSV_SUFFIX);
                    xmlConverter.convert(fileToConvert, outputXml);
                    csvConverter.convert(fileToConvert, outputCsv);
                    System.out.println("Konwersja zakończona sukcesem!");
                    System.out.println("Plik XML: " + outputXml.getAbsolutePath());
                    System.out.println("Plik CSV: " + outputCsv.getAbsolutePath());
                    break;
                } else {
                    System.out.println("Pliku nie można odczytać. Spróbuj inny plik:");
                }
            } else {
                System.out.println("To nie jest plik lub ścieżka jest nieprawidłowa. Spróbuj ponownie:");
            }
        }
    }
}
