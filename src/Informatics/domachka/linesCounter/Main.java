package Informatics.domachka.linesCounter;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinesCounter linesCounter = new LinesCounterImplRecursive();
        Path path = Path.of(new Scanner(System.in).nextLine());
        System.out.println(linesCounter.linesCount(path));
    }
}