package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_14_listing_files {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) throws IOException {
        logger.info("Java 8 Functional programming");
        System.out.println();

        Files.list(Paths.get(".")).forEach(System.out::println);
        System.out.println();

        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        System.out.println();

        String[] file1 = new File(".").list((File dir, String name)->name.endsWith("md"));
        System.out.println(Arrays.toString(file1));
        System.out.println();

        String[] file2 = new File(".").list((dir, name) ->name.endsWith("md"));
        System.out.println(Arrays.toString(file2));
        System.out.println();

        Files.newDirectoryStream(Paths.get("." ), path->path.toString().endsWith(".idea")).forEach(System.out::println);
        System.out.println();

        Files.newDirectoryStream(Paths.get("." ), path->{
            File file = new File(path.toString());
            return file.isHidden();
        }).forEach(System.out::println);
        System.out.println();

        File[] file3 = new File(".").listFiles(File::isHidden);
        System.out.println(file3.toString());
        System.out.println();

        List<File> files = Stream.of(new File(".").listFiles()).collect(Collectors.toList());
        System.out.println(files);
        System.out.println();

        String[] file4 = new File(".").list((dir, name) ->name.endsWith("idea"));
        File[] file5 = new File(".").listFiles((dir, name) ->name.endsWith("git"));
        System.out.println(Arrays.toString(file4));
        System.out.println(Arrays.toString(file5));
        System.out.println(Stream.of(file4).collect(Collectors.toList()));
        System.out.println(Stream.of(file5).collect(Collectors.toList()));
        System.out.println();
    }
}
