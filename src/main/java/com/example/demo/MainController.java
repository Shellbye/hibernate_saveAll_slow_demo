package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MainController {

    private UserDetailRepository repository;

    @Autowired
    public MainController(UserDetailRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String demo() {
        List<UserDetail> userDetailList = new LinkedList<>();
        int count = 2000;
        long pre = System.currentTimeMillis();
        while (count-- > 0) {
            UserDetail userDetail = new UserDetail();
            userDetail.setAge(10);
            userDetail.setName("Name");
            userDetailList.add(userDetail);
        }
        repository.saveAll(userDetailList);
        return String.valueOf(System.currentTimeMillis() - pre);
    }
}