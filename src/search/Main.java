package search;

import search.client.Search;
import search.searchstrategy.All;
import search.searchstrategy.Any;
import search.searchstrategy.None;
import search.searchstrategy.SearchStrategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static Data data = new Data();
    static void printAllPeople() {
        System.out.println("=== List of people ===");
        for (String row : data.getIndex()) {
            StringBuilder sb = new StringBuilder();
            for (String r : row.split(" ")) {
                sb.append(r).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void printMenu() {
        System.out.format("""
                                
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit
                """);
    }

    static int chooseOption() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    static void printExit() {
        System.out.println("Bye!");
    }

    public static void main(String[] args) {

        data.loadDataFromFile(args);

        while (true) {
            printMenu();
            int option = chooseOption();
            if (option == 1) {

                Search search = new Search();
                search.search(data);
            } else if (option == 2) {
                printAllPeople();
            } else if (option == 0) {
                printExit();
                break;
            } else {
                System.out.println("Incorrect option! Try again.");
            }

        }

    }
}
