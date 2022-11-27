package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main{
    private static String fileHeader = "full_name, email, location";
    protected static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();

        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch(IOException e)
        {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return lines;
    }

    protected static void removeLine(List<String> originalList, String line)
    {
        originalList.remove(line);
    }
    protected static List<String> getListWithoutDuplicates(List<String> list){
        Set<String> listAsSet = new HashSet<>(list);

        return new ArrayList<>(listAsSet);
    }
    protected static void sortList(List<String> list)
    {
        Collections.sort(list);
    }

    public static void main(String[] args) {
        List<String> originalList = readFileInList("/Users/gabicirceie/Documents/IntelliJ/Project/src/main/java/org/example/textfile.txt");

        removeLine(originalList, fileHeader);

        List<String> listWithoutDuplicates = getListWithoutDuplicates(originalList);
        sortList(listWithoutDuplicates);

        for (String row : listWithoutDuplicates) {
            System.out.println(row);
            System.out.println("\n");
        }
    }
}