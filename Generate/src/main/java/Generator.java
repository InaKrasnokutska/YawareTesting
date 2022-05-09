import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Generator {

    private static final String CSV_FILE = "..//TestingYaware//employees.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("firstname", "lastname", "email", "group_name"));
        ) {

            String[] names = {"Tetyana", "Iryna", "Maria", "Ilona", "Vira", "Nadia", "Lyubov", "Oleksiy", "Mykola", "Danylo", "Denys", "Taras"};
            String[] surnames = {"Kotenko", "Didenko", "Ilchuk", "Ostafiychuk", "Mykytyuk", "Krasnyuk", "Miskiv", "Onysko", "Padalko", "Telesyk", "Galushko", "Ivanchenko"};
            String email;

            Random rand = new Random();
            int nameIndex, surnameIndex;

            for (int i = 0; i < 10; ++i)
            {
                nameIndex = rand.nextInt(12);
                surnameIndex = rand.nextInt(12);

                email = names[nameIndex] + surnames[surnameIndex] + Integer.toString(rand.nextInt(2023)) + "@gmail.com";

                csvPrinter.printRecord(names[nameIndex], surnames[surnameIndex], email, "");
                csvPrinter.flush();
            }


        }
    }

}
