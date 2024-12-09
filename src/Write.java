import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    static boolean append = false;
    public static void createFile(String filename) {


        try {
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("Файл создан");

        } else {
            System.out.println("Файл уже существует");
            append = true;
        }
    } catch (
    IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
    }

    public static void writeFile(String filename, String data) {
        String[] split = data.split(" ");
                try {
            FileWriter writer = new FileWriter(filename, append);
            for (int i = 0; i < split.length; i++)  writer.write(" <"+split[i]+"> ");
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

}
