package com.example.demo.datafetchers

import com.example.demo.generated.types.Show
import com.example.demo.services.ShowsService
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired

@DgsComponent
class ShowDataFetcher {
    @Autowired
    lateinit var showsService : ShowsService

    @DgsQuery
    fun show(@InputArgument id: String?): Show? {
        System.out.println("ID: $id")
        return if (id==null) {
            null
        } else
            showsService.shows().filter { it.id.equals(id) }[0]
    }

}