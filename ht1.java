import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ht1 {

    

// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".


    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder result = new StringBuilder("select * from students where ");
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file, "UTF-8");
        String data = scanner.nextLine();
        data = data.trim();
        boolean flag = false;
        if (data.startsWith("{") && data.endsWith("}")) {
                    data = data.substring(1, data.length() - 1);
                }
        String[] pairs = data.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim().replace("\"", "");
            if (!value.equals("null")) {
                    result.append(key).append(" = ").append(value).append(" AND ");
                    flag = true;
            }
         }

         if (!flag) {
            System.out.println("Нет данных для поиска.");
            scanner.close();
            return; 
        }

         result.delete(result.length() - 5, result.length());
                
            
        scanner.close();
      
        System.out.println(result.toString());
    }
}
