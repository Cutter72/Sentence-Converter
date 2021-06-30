package pl.project;

import pl.project.converter.xml.XmlConverterImpl;

import java.util.Scanner;

public class Main {
    public static final String CMD_QUIT = "quit";

    public static void main(String[] args) {
        System.out.println("Wpisz lub wklej zdanie które chcesz przekonwertować:");
        String cmd;
        XmlConverterImpl xmlConverter = new XmlConverterImpl();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase(CMD_QUIT)) {
                break;
            }
        }
    }
}
