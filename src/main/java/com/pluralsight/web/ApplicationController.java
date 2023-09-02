package com.pluralsight.web;

import com.pluralsight.entity.Application;
import com.pluralsight.mutator.Mutation;
import com.pluralsight.repository.ApplicationRepository;
import com.pluralsight.resolver.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ApplicationController {
    private Query query;
    private Mutation mutation;


    public ApplicationController(Query query, Mutation mutation) {
        this.query = query;
        this.mutation = mutation;
    }

    @QueryMapping()
    public Application getApplication(@Argument long id) {
        return query.getApplication(id);
    }

    @QueryMapping
    public List<Application> findAllApplications(){
        return (List<Application>) query.findAllApplications();
    }

    @QueryMapping
    public long countApplications(){
        return query.countApplications();
    }

    @MutationMapping
    public Application newApplication(@Argument String name, @Argument String owner, @Argument String description){
        return mutation.newApplication(name, owner,description);
    }

    @MutationMapping
    public Boolean deleteApplication(@Argument Long id){
        return mutation.deleteApplication(id);
    }

    @MutationMapping
    public Application updateApplicationOwner(@Argument String newOwner, @Argument Long id){
        return mutation.updateApplicationOwner(newOwner, id);
    }
}
