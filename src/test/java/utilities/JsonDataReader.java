package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

    private static final ObjectMapper objectMapper =
            new ObjectMapper();

    public static <T> List<T> readList(
            String fileName,
            TypeReference<List<T>> typeReference) {

        try (InputStream inputStream =
                JsonDataReader.class
                        .getClassLoader()
                        .getResourceAsStream("testdata/" + fileName)) {

            if (inputStream == null) {

                throw new RuntimeException(
                        "File not found : " + fileName);
            }

            return objectMapper.readValue(
                    inputStream,
                    typeReference);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read JSON file : "
                            + fileName,
                    e);
        }
    }
}