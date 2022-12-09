package org.ogray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools {
    public static void createFolderIfNotExist(String sourceFolder) throws IOException {
            Files.createDirectories(Paths.get(sourceFolder));
    }

    public static String convertPackageToFolder(String str) {
        return str.replace('.', '/') + "/";
    }
}
