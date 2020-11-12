package com.epam.compositechain.data.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDataAcquirer implements DataAcquirer {
    private static final Logger LOGGER = LogManager.getLogger(FileDataAcquirer.class);

    @Override
    public String getText(String fileName) throws DataException {
        LOGGER.info("Getting text from file!");
        List<String> lines;
        StringBuilder stringBuilder;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            stringBuilder = new StringBuilder();
            lines.forEach(line -> stringBuilder.append(line).append('\n'));
        } catch (IOException e) {
            throw new DataException(e.getMessage());
        }
        return stringBuilder.toString();
    }
}