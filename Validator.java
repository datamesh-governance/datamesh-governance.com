import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Validator {

    public static void main(String[] args) throws IOException {
        List<Error> errors = new LinkedList<>();

        validate(errors, "policies");
        validate(errors, "architecture-decisions");

        errors.stream().forEach(System.out::println);

    }

    private static void validate(List<Error> errors, String folder) throws IOException {
        try (var groups = Files.newDirectoryStream(Path.of(folder))) {
            for (Path path : groups) {


                if (Files.isDirectory(path)) {
                    try (var policyFiles = Files.newDirectoryStream(path)) {
                        for (var policyFile : policyFiles) {
                            String category = policyFile.getParent().getFileName().toString().replace(".md", "");

                            if (Files.isDirectory(policyFile)) {
                                List<Path> policyOptions = new LinkedList<>();
                                try (var policyOptionsStream = Files.newDirectoryStream(policyFile, "*.md")) {
                                    for (var policyOption : policyOptionsStream) {
                                        policyOptions.add(policyOption);
                                    }
                                }

                                for (var policyOption : policyOptions) {
                                    validatePolicy(errors, policyOption, category, policyOptions);
                                }
                            }

                            if (Files.isRegularFile(policyFile) && policyFile.toString().endsWith(".md")) {
                                validatePolicy(errors, policyFile, category, List.of());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void validatePolicy(List<Error> errors, Path policyFile, String category, List<Path> policyOptions) throws IOException {
        var lines = Files.readAllLines(policyFile, StandardCharsets.UTF_8).stream().map(String::trim).toList();

        String categoryTitleCase = snakeCaseToTitleCase(category);
        assertLine(errors, policyFile, lines, "Category: " + categoryTitleCase);
        assertNotStartsWith(errors, policyFile, lines, "Status: ");
        assertNotStartsWith(errors, policyFile, lines, "## Options");
        assertLine(errors, policyFile, lines, "## Context");
        assertLine(errors, policyFile, lines, "## Decision");
        assertLine(errors, policyFile, lines, "## Consequences");
        assertLine(errors, policyFile, lines, "## Automation");
        assertLine(errors, policyFile, lines, "## Monitoring");
        assertPlatformInList(errors, policyFile, lines);

        for(var otherPolicyOption : policyOptions) {
            if (otherPolicyOption.equals(policyFile)) {
                continue;
            }

            assertLine(errors, policyFile, lines, "## Considered Alternatives");
            assertContains(errors, policyFile, lines, "(" + otherPolicyOption.getFileName().toString() + ")");
        }
    }

    private static String snakeCaseToTitleCase(String category) {
        return Arrays.stream(category.split("-")).map(word -> word.substring(0, 1).toUpperCase(Locale.ROOT) + word.substring(1)).collect(Collectors.joining(" "));
    }

    private static void assertPlatformInList(List<Error> errors, Path policyFile, List<String> lines) {
        var optional = lines.stream().filter(line -> line.startsWith("Platform: ")).findFirst();
        if (optional.isEmpty()) {
            return;
        }

        var platform = optional.get().substring("Platform: ".length());
        var platforms = Arrays.stream(platform.split(",")).map(String::trim).collect(Collectors.toSet());
        var allowedPlatforms = Set.of("AWS", "Databricks", "Azure Synapse Analytics", "BigQuery", "Generic Data Lake");
        platforms.removeAll(allowedPlatforms);

        if(!platforms.isEmpty()) {
            for (var p : platforms) {
              errors.add(new Error(policyFile, "Platform unknown '" + p + "'"));
            }
        }
    }

    private static void assertLine(List<Error> errors, Path policyFile, List<String> lines, String containsCheck) {
        if (!lines.contains(containsCheck)) {
            errors.add(new Error(policyFile, "Missing '" + containsCheck + "'"));
        }
    }

    private static void assertNotStartsWith(List<Error> errors, Path policyFile, List<String> lines, String containsCheck) {
        var errorLines = lines.stream().filter( line-> line.startsWith(containsCheck)).toList();
        if(!errorLines.isEmpty()) {
                    errors.add(new Error(policyFile, "Contains '" + containsCheck + "'"));
        }
    }

    private static void assertContains(List<Error> errors, Path policyFile, List<String> lines, String containsCheck) {
        var errorLines = lines.stream().filter( line-> line.contains(containsCheck)).toList();
        if(errorLines.isEmpty()) {
            errors.add(new Error(policyFile, "Missing '" + containsCheck + "'"));
        }
    }

    record Error(Path file, String error) {}
}
