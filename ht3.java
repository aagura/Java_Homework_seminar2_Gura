import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ht3 {

    

    // Дана json-строка (можно сохранить в файл и читать из файла)
    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
    // "предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    // Написать метод(ы), который распарсит json и, используя StringBuilder, 
    // создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    // Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.


    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();

        File file = new File("data3.txt");
        Scanner scanner = new Scanner(file, "UTF-8"); 
        String data = scanner.nextLine();
        scanner.close();
        if (data.startsWith("[") && data.endsWith("]")) {
            data = data.substring(1, data.length() - 1);
        }

        String[] elements = data.split("\\},\\{");

        for (String element : elements) {
            
            if (element.startsWith("{")) {
                element = element.substring(1);
            }
            if (element.endsWith("}")) {
                element = element.substring(0, element.length() - 1);
            }
            String[] pairs = element.split(",");

            String surname = null;
            String mark = null;
            String subject = null;

            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");

                if (key.equals("фамилия")) {
                    surname = value;
                } else if (key.equals("оценка")) {
                    mark = value;
                } else if (key.equals("предмет")) {
                    subject = value;
                }
            }

            
            result.append("Студент ").append(surname).append(" получил ").append(mark).append(" по предмету ").append(subject).append(".\n");
            
        }

        System.out.println(result.toString());
    }
}