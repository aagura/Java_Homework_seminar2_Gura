
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*; 

public class ht2 {
    //2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    public static void bubbleSort(int[] sortArr) throws IOException{
        Logger ll = Logger.getLogger(ht2.class.getName());

        String logsPath = "log.txt";
        FileHandler fh = new FileHandler(logsPath, false);
        ll.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        for (int i = 0; i < sortArr.length - 1; i++) { 
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;     
                }
                ll.info(Arrays.toString(sortArr) ); 
            }   
        }       
      }
    
    public static void main(String[] args) throws IOException{

      int[] array = {9, 6, 4, 1, 5, 0};
     bubbleSort(array);
     for(int i = 0; i < array.length; i++){
     System.out.print(array[i] + "\n");
        
     }
    }
}