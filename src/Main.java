import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder("");

        //Пункт 1
        makeDirectoryAndLog("D:/Games/Games", "src", log);
        makeDirectoryAndLog("D:/Games/Games", "res", log);
        makeDirectoryAndLog("D:/Games/Games", "savegames", log);
        makeDirectoryAndLog("D:/Games/Games", "temp", log);

        //Пункт 2
        makeDirectoryAndLog("D:/Games/Games/src", "main", log);
        makeDirectoryAndLog("D:/Games/Games/src", "test", log);

        //Пункт 3
        createFileAndLog("D:/Games/Games/src/main", "Main.java", log);
        createFileAndLog("D:/Games/Games/src/main", "Utils.java", log);

        //Пункт 4
        makeDirectoryAndLog("D:/Games/Games/res", "drawables", log);
        makeDirectoryAndLog("D:/Games/Games/res", "vectors", log);
        makeDirectoryAndLog("D:/Games/Games/res", "icons", log);

        //Пункт 5
        createFileAndLog("D:/Games/Games/temp", "temp.txt", log);
        System.out.println(log.toString());

        //Слитие логов
        try (FileWriter fileWriter = new FileWriter("D:/Games/Games/temp/temp.txt")) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void makeDirectoryAndLog(String path, String nameOfDir, StringBuilder log) {
        File file = new File(path, nameOfDir);
        LocalDateTime ldt = LocalDateTime.now();

        if (file.mkdir()) {
            log.append(ldt + " Директрория " + nameOfDir + " установлена в " + path);
            log.append("\n");
        } else {
            log.append(ldt + " Директория " + nameOfDir + " уже существует или произошла ошибка");
            log.append("\n");
        }
    }

    public static void createFileAndLog(String path, String nameOfFile, StringBuilder log) {
        File file = new File(path, nameOfFile);
        LocalDateTime ldt = LocalDateTime.now();
        try {
            if (file.createNewFile()) {
                log.append(ldt + " Файл " + nameOfFile + " был создан в " + path);
                log.append("\n");
            } else {
                log.append(ldt + " Произошла ошибка при создании " + nameOfFile + " или такой файл уже существует");
                log.append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
