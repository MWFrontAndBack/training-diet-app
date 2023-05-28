package com.example.trainingdietappbackend.controllers.users;


import com.example.trainingdietappbackend.dto.UserDto;
import com.example.trainingdietappbackend.dto.mapper.mapperUtil.MapperUtil;
import com.example.trainingdietappbackend.entities.Admin;
import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/public/admin-page")
@CrossOrigin(origins = "*")
public class AdminPageController {

    private UserRepository userRepository;

    public AdminPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping@CrossOrigin


    public ResponseEntity<List<UserDto>> getUsers(){
        List<User> all = userRepository.findAll();
        all.removeIf(a-> a.getEmail().equals("admin@gmail.com"));

        List<UserDto> listmapped = all.stream().map(a -> MapperUtil.map(a, UserDto.class)).toList();
        if(all.isEmpty()){
            return (ResponseEntity<List<UserDto>>) ResponseEntity.notFound();

        }
        return ResponseEntity.ok(listmapped);
    }

    @DeleteMapping
    @RequestMapping(("/delete-user/{id}"))
    public Object deleteNote(@PathVariable(name = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        Admin admin = userRepository.findAdminByEmail(email);
        if(admin.isCanManageUsers()) {
            User user = userRepository.findById(id).orElseThrow();
            userRepository.delete(user);
            return ResponseEntity.ok(user);

        }
return ResponseEntity.badRequest();

    }
}
