package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class JTest {
    List<String> originalList = readFileInList("/Users/gabicirceie/Documents/IntelliJ/Project/src/test/java/org/example/textfile.txt");
    String fileHeader = "full_name, email, location";
    @Test
    public void removeLine_removesHeader_succesfully(){
        List<String> expectedList = readFileInList("/Users/gabicirceie/Documents/IntelliJ/Project/src/test/java/org/example/removeLine_removesHeader_succesfully.txt");

        removeLine(originalList, fileHeader);

        assertEquals(expectedList, originalList);
    }

    @Test
    public void removeLine_removeDuplicates_succesfully(){
        List<String> expectedList = readFileInList("/Users/gabicirceie/Documents/IntelliJ/Project/src/test/java/org/example/removeLine_removeDuplicates_succesfully.txt");
        removeLine(originalList, fileHeader);
        List<String> listWithoutDuplicates = getListWithoutDuplicates(originalList);

        assertEquals(expectedList, listWithoutDuplicates);
    }

    @Test
    void removeLine_sort_succesfully() {
        List<String> expectedList = readFileInList("/Users/gabicirceie/Documents/IntelliJ/Project/src/test/java/org/example/removeLine_sort_succesfully.txt");

        removeLine(originalList, fileHeader);
        List<String> listWithoutDuplicates = getListWithoutDuplicates(originalList);
        sortList(listWithoutDuplicates);

        assertLinesMatch(expectedList, listWithoutDuplicates);

    }
}