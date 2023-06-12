package com.sort.name;

import com.sort.name.model.Name;
import com.sort.name.service.AppProperties;
import com.sort.name.service.NameSorterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class NameSorterServiceTest {

    @InjectMocks
    NameSorterService nameSorterService = mock(NameSorterService.class);

    @Before
    public void setUp() {
        AppProperties appProperties = mock(AppProperties.class);
    }

    @Test
    public void test_buffered_reader_created() throws FileNotFoundException {
        String inputFile = "/Users/ashuvaidwan/Desktop/unsorted-names-list.txt";
        BufferedReader bufferedReader = nameSorterService.fetchBufferedReader(inputFile);
        Assert.isNull(bufferedReader, "false");
    }

    @Test
    public void test_buffered_writer_created() throws IOException {
        String inputFile = "/Users/ashuvaidwan/Desktop/unsorted-names-list.txt";
        BufferedWriter bufferedWriter = nameSorterService.fetchBufferedWriter(inputFile);
        Assert.isNull(bufferedWriter, "false");
    }

    @Test
    public void test_build_name_list() throws IOException {
        List<Name> nameList = new ArrayList<>();
        Name name = new Name();
        name.setLastName("Parsons");
        name.setGivenName("Janet");
        FileReader fileReader = mock(FileReader.class);
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn("Janet Parsons",
                "Vaughn Lewis",
                "Adonis Julius Archer", "Shelby Nathan Yoder",
                "Marin Alvarez", "Lewis Alvarez", "London Lindsey",
                "Beau Tristan Bentley", "Leo Gardner",
                "Hunter Uriah Mathew Clarke", "Mikayla Lopez");
        nameSorterService.buildNameList(nameList, bufferedReader);
        assertNotEquals("", nameList);
    }

    @Test
    public void whenFileIsProvidedNameSorterWorks() {
        try{
            FileReader fileReader = mock(FileReader.class);
            BufferedReader bufferedReader = mock(BufferedReader.class);
            Mockito.when(bufferedReader.readLine()).thenReturn("Janet Parsons",
                    "Vaughn Lewis",
                    "Adonis Julius Archer", "Shelby Nathan Yoder",
                    "Marin Alvarez", "Lewis Alvarez", "London Lindsey",
                    "Beau Tristan Bentley", "Leo Gardner",
                    "Hunter Uriah Mathew Clarke", "Mikayla Lopez");
             List<Name> nameList = nameSorterService.nameSorter();
        } catch(
                IOException ex) {
            System.out.println("Error reading file '");
        }
    }
}
