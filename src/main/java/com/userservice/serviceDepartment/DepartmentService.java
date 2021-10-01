package com.userservice.serviceDepartment;

import com.userservice.entity.User;
import com.userservice.restRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DepartmentService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @Value("${app.url.department}")
    private String URL;

    public UserVsDepartment getUserWithDepartment(Long userId){
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject(URL+"/"+userId,Department.class);
        return new UserVsDepartment(user,department);
    }
}
