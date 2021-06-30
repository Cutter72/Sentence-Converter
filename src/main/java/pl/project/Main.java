package pl.project;

import pl.project.converter.csv.CsvConverterImpl;
import pl.project.converter.xml.XmlConverterImpl;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static final String CMD_QUIT = "quit";

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
                    System.out.println("Naciśnij Enter aby rozpocząć konwersję...");
                    scanner.nextLine();
                    System.out.println(fileToConvert.getName());
                    String fileToConvertAbsolutePath = fileToConvert.getAbsolutePath();
                    String outputFilePath = fileToConvertAbsolutePath.substring(0, fileToConvertAbsolutePath.length() - 4);
                    File outputFile = new File(outputFilePath);
                    xmlConverter.convert(fileToConvert, new File(outputFile + ".xml"));
                    csvConverter.convert(fileToConvert, new File(outputFile + ".csv"));
                    System.out.println("Przekonwertowano.");
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
