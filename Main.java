import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    /*
Задание 1. Преобразование строки в число
Реализуйте метод convertAndSum, который принимает массив строк, каждая
из которых должна быть преобразована в целое число. Метод возвращает
сумму всех чисел. Если хотя бы одна строка не может быть преобразована в
число, метод должен выбросить исключение NumberFormatException.
Дополнительно, если сумма чисел превышает 100, выбрасывайте
ArithmeticException с сообщением "Превышен лимит суммы".

 */
    public static int convertAndSum(String[] arr) throws NumberFormatException, ArithmeticException{
        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        if (sum > 100) throw new ArithmeticException("the amount exceeds 100");
        return sum;
    }

    /*
    Задача 2. Объединение массивов с проверкой длины и содержимого
Реализуйте метод mergeAndValidateArrays, который принимает два
массива целых чисел. Метод должен объединить массивы и вернуть новый
массив. Если длины массивов не равны, выбрасывайте исключение
IllegalArgumentException. Если хотя бы один элемент объединенного
массива отрицательный, выбрасывайте исключение RuntimeException с
сообщением "Обнаружен отрицательный элемент".

     */
    public static int[] mergeAndValidateArrays(int[] arr1, int[] arr2) throws IllegalArgumentException, RuntimeException{
        if (arr1.length != arr2.length) throw new IllegalArgumentException("Массивы разной длины");
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]<0 | arr2[i] < 0) throw new RuntimeException("Обнаружен отрицательный элемент");
            result[i] = arr1[i];
            result[i+arr1.length] = arr2[i];
        }
        return result;
    }

    /*
    Задача 3. Обработка исключений для разностных массивов
Реализуйте метод subArraysWithExceptionHandling, который принимает
два массива целых чисел. Метод должен возвращать новый массив, где
каждый элемент является разностью соответствующих элементов двух входных
массивов. Если длины массивов не равны, выбрасывайте
IllegalArgumentException с сообщением "Массивы разной длины". Если
результат разности оказывается отрицательным, выбрасывайте
RuntimeException с сообщением "Отрицательный результат разности".
     */
    public static int[] subArraysWithExceptionHandling(int[] arr1, int[] arr2) throws RuntimeException, IllegalArgumentException{
        if (arr1.length != arr2.length) throw new IllegalArgumentException("Массивы разной длины");
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
            if (result[i] < 0) throw new RuntimeException("Отрицательный результат разности");
        }
        return result;
    }
    /*
    Задача 4. Поиск и замена строк
Реализуйте метод findAndReplace, который принимает массив строк, строку
для поиска и строку для замены. Если искомая строка не найдена, добавьте
сообщение об ошибке в список. Верните новый массив строк с выполненной
заменой.
     */

    public static String[] findAndReplace(String[] arr, String searchEl, String replace, List<String> errors){
        boolean found = false;
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(searchEl)){
                result[i] = replace;
                found = true;
            }
            else result[i] = arr[i];
        }
        if (!found) errors.add("Строка \"" + searchEl +"\" не найдена");
        return result;
    }
}