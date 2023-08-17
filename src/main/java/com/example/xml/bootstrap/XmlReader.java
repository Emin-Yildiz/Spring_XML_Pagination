package com.example.xml.bootstrap;

import com.example.xml.domain.User;
import com.example.xml.domain.Users;
import com.example.xml.service.UserService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class XmlReader implements ApplicationRunner {

    private final XmlMapper xmlMapper;

    public XmlReader(XmlMapper xmlMapper){
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        File file = new File("users.xml");
        Users users = xmlMapper.readValue(file, Users.class);
        users.getUsers().forEach(
                user -> UserService.userList.add(user)
        );
    }
}
