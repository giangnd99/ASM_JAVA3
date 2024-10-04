package util;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class XImage {

    public static void saveFile(Part part, String saveDirectory) throws IOException {
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
        File destFile = new File(saveDirectory + File.separator + fileName);
        try (InputStream inputStream = part.getInputStream()) {
            Files.copy(inputStream, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING); 
        } catch (IOException e) {
            throw new IOException("Lỗi khi lưu tệp: " + fileName, e); 
        }
    }
}
