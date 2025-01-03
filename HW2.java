import java.util.Arrays;
import java.util.Formatter;

public class HW2 {
    public static void main(String[] args) {
        int intEl = Integer.parseInt("ss");
    }
    /*
    Задание 1. Проверка корректности даты
Напишите метод, который проверяет, является ли введенная строка корректной
датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01
до 9999-12-31. Если дата корректна, возвращайте её. Если нет — сообщение
об ошибке.
     */
    public static String validDate(String date) throws IllegalArgumentException{
        if (date.length() != 10) throw new IllegalArgumentException("Invalid date format. Please use YYYY-mm-dd");
        String[] arr = date.split("-");
        if (arr.length != 3) throw new IllegalArgumentException("Invalid date format. Please use YYYY-mm-dd");
        int[] intArr = new int[3];
        for (int i = 0; i < arr.length; i++){
            try
            {
                int intEl = Integer.parseInt(arr[i]);
                if (intEl <=0) new IllegalArgumentException("Invalid date format. There are letters in the date");
                intArr[i] = intEl;
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Invalid date format. Please use YYYY-mm-dd");
            }
        }
        if (intArr[0]>9999) throw new IllegalArgumentException("Invalid date format. The specified year is out of range");
        if (intArr[1]>12) throw new IllegalArgumentException("Invalid date format. The specified month is out of range");
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (intArr[1] ==2 && isLeapYear(intArr[0])) daysInMonth[2] = 29;
        if (intArr[2] != daysInMonth[intArr[1]]) throw new IllegalArgumentException("Invalid date format. there are more days in a month than possible");

        return date;
    }
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 ==
                0);
    }
    /*
    Напишите метод, который проверяет, является ли введенная строка
палиндромом. Если строка палиндром, возвращайте "Palindrome". Если нет
— "Not a palindrome".
     */
    public static String isPalindrome(String str){
        String cleanedInput = str.replace(" ", "").toLowerCase();
        boolean flag = true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - (i + 1))) {
                flag = false;
                break;
            }
        }
        if (flag) return "Palindrome";
        else return "Not a palindrome";
    }
    /*
    Задача 3. Сортировка массива строк
Напишите метод, который принимает массив строк и сортирует его в
алфавитном порядке. Если входной массив null, метод должен вернуть пустой
массив и вывести сообщение об ошибке.
     */

    public static String[] sortArrays(String[] arr){
        try {
            if (arr == null) {
                System.out.println("Array is null");
                return new String[0];
            }

            Arrays.sort(arr);
            return arr;
        }
        catch (Exception e){
            System.out.println("Sort error");
            return new String[0];
        }
    }

    /*
    Задача 4. Нахождение среднеарифметического числа
Напишите метод, который находит среднее значение массива целых чисел.
Если массив пустой или null, метод должен вернуть Double.NaN и вывести
сообщение об ошибке.
     */
    public static Double average(int[] arr){
        if (arr == null){
            System.out.println("Array is null");
            return Double.NaN;
        }
        if (arr.length == 0){
            System.out.println("Array length is null");
            return Double.NaN;
        }
        Double sum = 0.0;
        for (int el: arr){
            sum += el;
        }
        return sum/arr.length;
    }



}
