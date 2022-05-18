package My_pieces.Extension;

import java.nio.file.Path;

public class Extension {
    public static String getExtension(Path path) {
        String nameFile = path.toString();
        int lastIndexPoint = nameFile.lastIndexOf('.');
        if (lastIndexPoint <= 0) return "";
        return nameFile.substring(lastIndexPoint + 1);
    }
}
