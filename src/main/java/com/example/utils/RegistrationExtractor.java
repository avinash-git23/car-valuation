package com.example.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationExtractor {
    // UK registration pattern: two letters, two digits, optional space, three letters.
    private static final Pattern REG_PATTERN = Pattern.compile("([A-Z]{2}\\d{2}\\s?[A-Z]{3})");

    public static List<String> extractRegistrations(String filePath) throws IOException {
        // Read all bytes from the file at the given path and convert to a String using UTF-8 encoding.
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);

        List<String> regs = new ArrayList<>();
        Matcher matcher = REG_PATTERN.matcher(content);
        while (matcher.find()) {
            regs.add(matcher.group(1).trim());
        }
        return regs;
    }
}
