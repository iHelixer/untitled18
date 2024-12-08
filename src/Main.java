import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            Path directory = Paths.get("users_directory");
            if (!Files.exists(directory)) {
                Files.createDirectory(directory);
                System.out.println("Директорію створено: " + directory.toAbsolutePath());
            }


            Path sourceFile = directory.resolve("users.txt");
            Path targetFile = directory.resolve("copied_users.txt");


            List<String> userData = new ArrayList<>();
            userData.add("Ім'я: Oliver, Вік: 35, Стать: Чоловіча");
            userData.add("Ім'я: Lilly, Вік: 22, Стать: Жіноча");
            userData.add("Ім'я: Robert, Вік: 27, Стать: Чоловіча");

            Files.write(sourceFile, userData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Дані записані у файл: " + sourceFile.toAbsolutePath());


            List<String> lines = Files.readAllLines(sourceFile);
            System.out.println("Текст у файлі:");
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("Кількість рядків у файлі: " + lines.size());


            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Дані скопійовані до файлу: " + targetFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }

    }
}