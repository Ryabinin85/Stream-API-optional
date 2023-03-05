import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;


/**
 * Задание 1
 * Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
 * Данный метод принимает на вход 3 элемента:
 * Stream<? extends T> stream,
 * Comparator<? super T> order,
 * BiConsumer<? super T, ? super T> minMaxConsumer
 * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
 * minMaxConsumer.accept(min, max);
 * Если стрим не содержит элементов, то вызовите
 * minMaxConsumer.accept(null, null);
 * Критерии
 * Задача решена корректно
 * Реализация через коллекцию(Например List или Queue)
 * Логически верно определили результат
 * Корректное получение необходимых данных
 * Соблюден кодстайл
 * <p>
 * Задание 2
 * Реализуйте метод, который принимает на вход Список целых чисел и определяет количество четных и выводит их в консоль.
 * Решать именно с применением Stream API
 * Критерии
 * Задача решена корректно
 * Задача решена одним из двух способов
 * Соблюден кодстайл
 * Правильно реализован предикат
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> list = fill(20);
        findEven(list);

        Stream<Integer> stream = list.stream();
        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.println("min: " + x + " max: " + y));
    }

    public static List<Integer> fill(int size) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(100)).limit(size).toList();
    }

    public static <A> void findMinMax(
            Stream<? extends A> stream,
            Comparator<? super A> order,
            BiConsumer<? super A, ? super A> minMaxConsumer) {

        List<? extends A> list = stream.sorted(order).toList();

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void findEven(List<Integer> list) {
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }

}
