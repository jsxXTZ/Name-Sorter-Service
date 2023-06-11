package com.sort.name.resource;

import com.sort.name.model.Name;
import com.sort.name.service.NameSorterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NameResource {

    private final NameSorterService nameSorterService;
    @GetMapping("/sort-names")
    public List<Name> sortNameList(){
        return nameSorterService.nameSorter();
    }
}
