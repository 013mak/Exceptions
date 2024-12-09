import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData {
    private static String filename;
    public static String inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дата рождения(dd.mm.yyyy), номер телефона, пол(f/m), разделенные пробелом: ");
        String data = scanner.nextLine();
        String[] split = data.split(" ");

        if (split.length != 6) {
            throw new IllegalArgumentException("Введено неверное количество полей");

        }
        filename = split[0];
        for (int i = 0; i < 2; i++) {

            if (!isAlphabetic(split[i])) throw new IllegalArgumentException("Введены неверные ФИО");

        }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(split[3]);
        } catch (
                ParseException e) {
            throw new IllegalArgumentException("Введена неверная дата рождения");

        }
        try {
            Integer.parseInt(split[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Введен неверный телефон");
        }

        if (!(split[5].equals("f")) && !(split[5].equals("m")))
            throw new IllegalArgumentException("Введен неверный пол");
        return data;
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        InputData.filename = filename;
    }

    public static boolean isAlphabetic(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }


}
