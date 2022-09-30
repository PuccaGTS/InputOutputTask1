import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder("");
        String arrOfDir [] = {
                "D:/Games/Games/src",
                "D:/Games/Games/res",
                "D:/Games/Games/savegames",
                "D:/Games/Games/temp",
                "D:/Games/Games/src/main",
                "D:/Games/Games/src/test",
                "D:/Games/Games/res/drawables",
                "D:/Games/Games/res/vectors",
                "D:/Games/Games/res/icons"
        };
        String arrOfFiles [] = {
                "D:/Games/Games/src/main/Main.java",
                "D:/Games/Games/src/main/Utils.java",
                "D:/Games/Games/temp/temp.txt"
        };

        makeDirAndLog(arrOfDir, log);
        createFilesAndLog(arrOfFiles, log);


        //Слитие логов
        try (FileWriter fileWriter = new FileWriter("D:/Games/Games/temp/temp.txt")) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void makeDirAndLog(String[] arrOfDir, StringBuilder log) {
        for (String dirPath: arrOfDir) {
            File file = new File(dirPath);
            LocalDateTime ldt = LocalDateTime.now();

            if (file.mkdir()) {
                log.append(ldt + " Директрория " + dirPath + " установлена");
                log.append("\n");
            } else {
                log.append(ldt + " Директория " + dirPath + " уже существует или произошла ошибка");
                log.append("\n");
            }
        }
    }


    public static void createFilesAndLog(String[] arrOfFiles, StringBuilder log) {
        for (String filesPath:arrOfFiles) {
            File file = new File(filesPath);
            LocalDateTime ldt = LocalDateTime.now();
            try {
                if (file.createNewFile()) {
                    log.append(ldt + " Файл " + filesPath + " был создан");
                    log.append("\n");
                } else {
                    log.append(ldt + " Произошла ошибка при создании " + filesPath + " или такой файл уже существует");
                    log.append("\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
