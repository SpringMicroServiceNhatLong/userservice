package com.userservice.serviceDepartment;

import com.userservice.entity.User;
import com.userservice.restRepository.UserRepository;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @Value("${app.url.department}")
    private String URL;

    private UserVsDepartment fallbackMethod(Long userId, RequestNotPermitted requestNotPermitted){
        return new UserVsDepartment(new User(),new Department());
    }

    @RateLimiter(name = "multipleRateLimiters_rps_limiter", fallbackMethod = "fallbackMethod")
    public UserVsDepartment rpsLimitedSearch(Long userId) {
        return getUserWithDepartment(userId);
    }

    @Retry(name = "throwingExceptionVsInterval", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "multipleRateLimiters_rpm_limiter", fallbackMethod = "fallbackMethod")
    public UserVsDepartment getUserWithDepartment(Long userId){
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject(URL+"/"+userId,Department.class);
        return new UserVsDepartment(user,department);
    }
}
