package com.example.xml.service;

import com.example.xml.bootstrap.XmlReader;
import com.example.xml.domain.User;
import com.example.xml.domain.Users;
import com.example.xml.model.UserDto;
import com.example.xml.model.response.GenericPagedDto;
import com.example.xml.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final XmlMapper xmlMapper;

    public UserService(UserRepository userRepository, XmlMapper xmlMapper){
        this.userRepository = userRepository;
        this.xmlMapper = xmlMapper;
    }

    @Getter
    public static List<User> userList = new ArrayList<>();

    public List<User> getUsersFromXml(){
        return userList;
    }

    public String addReadUsersFromXml(List<User> userList){
        if (!userList.isEmpty()){
            userRepository.saveAll(userList);
            return "Users added";
        }else {
            return "Users added failed";
        }
    }

    public void add(User user){
        userRepository.save(user);
    }
    public List<User> getUsersFromDb(){
        return userRepository.findAll();
    }

    public GenericPagedDto<User> findUserWithPagination(int pageNumber, int pageSize){ // dosyayı sistem okuduğu zaman
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> users = userRepository.findAll(pageable);

        return new GenericPagedDto(users.stream()
                .collect(Collectors.toList()),pageable, users.getTotalElements()
        );
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public List<User> addUsersFromFile(MultipartFile file) { // sisteme dosya yüklendiği zaman
        Users users;
        List<User> userList = new ArrayList<>();
        try {
            users = xmlMapper.readValue(file.getInputStream(), Users.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        users.getUsers().forEach(
                user -> userList.add(user)
        );

        return userList;
    }
}
