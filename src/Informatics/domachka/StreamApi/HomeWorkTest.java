package Informatics.domachka.StreamApi;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkTest {
    @Test
    void checkTask1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // TODO: Применить умножение каждого элемента на 2
        list = list.stream().map(x -> x * 2).toList();

        assertEquals(2, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(6, list.get(2));
        assertEquals(8, list.get(3));
    }

    @Test
    void checkTask2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // TODO: Отфильтровать элементы, оставив только четные
        list = list.stream().filter(x -> x % 2 == 0).toList();

        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(4, list.get(1));
    }

    @Test
    void checkTask3() {
        List<String> list = Arrays.asList("Ivanov", "Sidorov", "Antonov", "Kuznecov", "Kulikov", "Ahmetov");

        // TODO: Отсортировать по алфавиту
        list = list.stream().sorted().toList();

        assertEquals("Antonov", list.get(1));
        assertEquals("Ivanov", list.get(2));
        assertEquals("Kuznecov", list.get(4));
    }

    @Test
    void checkTask4() {
        List<Student> list = Arrays.asList(
                new Student("Ivan", "Ivanov", 50),
                new Student("Vasya", "Sidorov", 60),
                new Student("Anton", "Antonov", 70),
                new Student("Andrey", "Kuznecov", 80),
                new Student("Oleg", "Kulikov", 10),
                new Student("Ashot", "Ahmetov", 20)
        );

        // TODO: Отсортировать по score и по алфавиту, выбрать только тех, у кого score больше или равно 56
        list = list.stream().filter(x -> x.getScore() >= 56).toList();

        Comparator<Student> comparator = new Comparator<>() {
            public int compare(Student a, Student b) {
                if (a.getFirstName().compareTo(b.getFirstName()) != 0)
                    return a.getFirstName().compareTo(b.getFirstName());
                return a.getLastName().compareTo(b.getLastName());
            }
        };

        list = list.stream().sorted(comparator).toList();

        assertEquals("Kuznecov", list.get(0).getLastName());
        assertEquals("Antonov", list.get(1).getLastName());
        assertEquals(60, list.get(2).getScore());
    }
}