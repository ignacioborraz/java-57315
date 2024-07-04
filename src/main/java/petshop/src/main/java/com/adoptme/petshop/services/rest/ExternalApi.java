package com.adoptme.petshop.services.rest;

import com.adoptme.petshop.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalApi {

    public User saveExt(User data) {
        RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.postForObject(BASE_URL, data, User.class);
    }

    public List<User> findAllPersonsExt() {
        RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.getForObject(BASE_URL, List.class);
    }

    public User findByIdExt(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://jsonplaceholder.typicode.com/users/"+id;
        return restTemplate.getForObject(BASE_URL, User.class);
    }

    public void updateExt(Long id, User data) {
        RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://jsonplaceholder.typicode.com/users/"+id;
        restTemplate.put(BASE_URL, data);
    }

    public void deleteByIdExt(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://jsonplaceholder.typicode.com/users/"+id;
        restTemplate.delete(BASE_URL);
    }

}
