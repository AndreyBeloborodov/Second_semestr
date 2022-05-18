package Informatics.domachka.linesCounter;

import My_pieces.Extension.Extension;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LinesCounterImplRecursive implements LinesCounter {

    @Override
    public long linesCount(Path pathDirectory) {
        long result = 0;
        try(DirectoryStream<Path> files = Files.newDirectoryStream(pathDirectory)) {
            for (Path path : files) {
                if (Files.isRegularFile(path)) result += linesCountToFail(path);
                else result += linesCount(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int linesCountToFail(Path path) {
        String extension = "java";
        if (!Extension.getExtension(path).equals(extension)) return 0;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = 0;
        for (String str: lines) result += str.isEmpty() ? 0 : 1;
        return result;
    }

}
