package com.sort.name.service;

import com.sort.name.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class NameSorterService {

    @Autowired
    AppProperties appProperties;

    public List<Name> nameSorter() {
        List<Name> nameList = new ArrayList<>();
        fetchUnsortedNames(nameList, appProperties.getInputFile());
        Collections.sort(nameList, Comparator.comparing(Name::getLastName).thenComparing(Name::getGivenName));
        writeSortedNames(nameList, appProperties.getOutputFile());
        printSortedNames(nameList);
        return nameList;
    }

    public BufferedReader fetchBufferedReader(String inputFile) throws FileNotFoundException {
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    public BufferedWriter fetchBufferedWriter(String outputFile) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        return bufferedWriter;
    }

    public void buildNameList(List<Name> nameList, BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Name name = new Name();
            name.setLastName(line.substring(line.lastIndexOf(" ") + 1));
            name.setGivenName(line);
            nameList.add(name);
        }
    }

    public void fetchUnsortedNames(List<Name> nameList, String inputFile){
        try {
            BufferedReader bufferedReader = fetchBufferedReader(inputFile);
            buildNameList(nameList, bufferedReader);
            bufferedReader.close();
        } catch (
                FileNotFoundException ex) {
            System.out.println("Unable to open file '" + inputFile + "'");
        } catch (
                IOException ex) {
            System.out.println("Error reading file '" + inputFile + "'");

        }
    }

    public void writeSortedNames(List<Name> nameList, String outputFile){
        try {
            BufferedWriter bufferedWriter = fetchBufferedWriter(outputFile);
            for (Name item : nameList) {
                bufferedWriter.write(item.getGivenName());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + outputFile + "'");
        }
    }

    public void printSortedNames(List<Name> nameList){
        for (Name item : nameList) {
            System.out.println(item.getGivenName());
        }
    }
}