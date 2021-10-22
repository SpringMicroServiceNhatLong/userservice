package com.userservice.serviceDepartment;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWithDepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("userwithdeparment/{id}")
    public UserVsDepartment getUserWithDep(@PathVariable("id") Long id){
        return service.rpsLimitedSearch(id);
    }
}
