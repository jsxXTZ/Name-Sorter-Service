package com.sort.name;

import com.sort.name.model.Name;
import com.sort.name.service.NameSorterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class NameSorterServiceTest {

    @InjectMocks
    NameSorterService nameSorterService = mock(NameSorterService.class);

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(nameSorterService, "inputFile", "/Users/ashuvaidwan/Desktop/unsorted-names-list.txt");
        ReflectionTestUtils.setField(nameSorterService, "outputFile", "sorted-names-list.txt");

    }

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        try{
            FileReader fileReader = mock(FileReader.class);
            BufferedReader bufferedReader = mock(BufferedReader.class);
            Mockito.when(bufferedReader.readLine()).thenReturn("Janet Parsons", "Vaughn Lewis", "Adonis Julius Archer");
             List<Name> nameList = nameSorterService.nameSorter();
        } catch(
                IOException ex) {
            System.out.println("Error reading file '");
        }
    }
}
