package com.example.demo.datafetchers;

import com.example.demo.generated.types.Director;
import com.example.demo.service.DirectorService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class DirectorsDatafetcher {

    @Autowired
    private DirectorService directorService;

    @DgsQuery
    public List<Director> directors(@InputArgument String name) {
        if (name!=null) {
            return directorService.directors().stream().filter(director -> name.equals(director.getName())).collect(Collectors.toList());
        }else {
            return directorService.directors();
        }
    }

    @DgsQuery
    public Director director(@InputArgument String id) {
        if (id == null) {
            return null;
        }
        return directorService.directors().stream().filter(director -> director.getId().equals(id)).findFirst().get();
    }
}
