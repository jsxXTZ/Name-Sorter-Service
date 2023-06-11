package com.sort.name.resource;

import com.sort.name.service.NameSorterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NameResource {

    private final NameSorterService nameSorterService;
    @GetMapping("/sort-names")
    public void sortNameList(){
        nameSorterService.nameSorter();
    }
}
