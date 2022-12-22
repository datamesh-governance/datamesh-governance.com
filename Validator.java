import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Validator {

    public static final Set<String> ALLOWED_PLATFORMS = Set.of(
            "AWS",
            "Databricks",
            "Azure Synapse Analytics",
            "BigQuery",
            "Generic Data Lake",
            "Snowflake"
    );

    public static void main(String[] args) throws IOException {
        List<Error> errors = new LinkedList<>();

        validate(errors, Path.of("policies"));
        validate(errors, Path.of("architecture-decisions"));

        errors.forEach(System.out::println);

    }

    private static void validate(List<Error> errors, Path folder) throws IOException {
        for (var categoryPath : getPathsInFolder(folder)) {
            for (var policyPath : getPathsInFolder(categoryPath)) {
                var category = policyPath.getParent().getFileName().toString().replace(".md", "");

                var policyOptionPaths = getPathsInFolder(policyPath);
                for (var policyOptionPath : policyOptionPaths) {
                    validatePolicy(errors, policyOptionPath, category, policyOptionPaths);
                }

                validatePolicy(errors, policyPath, category, List.of());
            }
            validatePolicy(errors, categoryPath, null, List.of());
        }
    }

    private static List<Path> getPathsInFolder(Path folder) throws IOException {
        if (!Files.isDirectory(folder)) {
            return List.of();
        }

        List<Path> paths = new LinkedList<>();
        try (var pathDirectoryStream = Files.newDirectoryStream(folder)) {
            for (var path : pathDirectoryStream) {
                paths.add(path);
            }
        }
        return paths;
    }

    private static void validatePolicy(List<Error> errors, Path policyFile, String category, List<Path> policyOptions) throws IOException {
        if (!Files.isRegularFile(policyFile) || !policyFile.getFileName().toString().endsWith(".md")) {
            return;
        }

        var lines = Files.readAllLines(policyFile, StandardCharsets.UTF_8).stream().map(String::trim).toList();

        if (category != null) {
            var categoryTitleCase = snakeCaseToTitleCase(category);
            assertLine(errors, policyFile, lines, "Category: " + categoryTitleCase);
        }
        assertNotStartsWith(errors, policyFile, lines, "Status: ");
        assertNotStartsWith(errors, policyFile, lines, "## Options");
        assertLine(errors, policyFile, lines, "## Context");
        assertLine(errors, policyFile, lines, "## Decision");
        assertLine(errors, policyFile, lines, "## Consequences");
        assertLine(errors, policyFile, lines, "## Automation");
        assertLine(errors, policyFile, lines, "## Monitoring");
        assertPlatformInList(errors, policyFile, lines);

        for (var otherPolicyOption : policyOptions) {
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
        platforms.removeAll(ALLOWED_PLATFORMS);

        if (!platforms.isEmpty()) {
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
        var errorLines = lines.stream().filter(line -> line.startsWith(containsCheck)).toList();
        if (!errorLines.isEmpty()) {
            errors.add(new Error(policyFile, "Contains '" + containsCheck + "'"));
        }
    }

    private static void assertContains(List<Error> errors, Path policyFile, List<String> lines, String containsCheck) {
        var errorLines = lines.stream().filter(line -> line.contains(containsCheck)).toList();
        if (errorLines.isEmpty()) {
            errors.add(new Error(policyFile, "Missing '" + containsCheck + "'"));
        }
    }

    record Error(Path file, String error) {
    }
}
