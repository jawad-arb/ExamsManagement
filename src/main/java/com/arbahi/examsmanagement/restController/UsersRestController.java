//package com.arbahi.examsmanagement.restController;
//
//import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
//import com.arbahi.examsmanagement.dto.UsersDTO;
//import com.arbahi.examsmanagement.dtoMapper.UsersDTOMapper;
//import com.arbahi.examsmanagement.entity.User;
//import com.arbahi.examsmanagement.service.UsersService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/users")
//@RequiredArgsConstructor
//public class UsersRestController {
//    private final UsersService usersService;
//    private final UsersDTOMapper mapper;
//
//    @PostMapping
//    public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersDTO usersDTO) {
//        User createdUser = usersService.createUser(mapper.convertToEntity(usersDTO));
//        return new ResponseEntity<>(mapper.convertToDTO(createdUser), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<UsersDTO> getUserById(@PathVariable Integer userId) {
//        Optional<User> optionalUser = Optional.ofNullable(usersService.getUserById(userId));
//
//        if (optionalUser.isPresent()) {
//            UsersDTO userDTO = mapper.convertToDTO(optionalUser.get());
//            return ResponseEntity.ok(userDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List<UsersDTO>> getAllUsers() {
//        List<User> users = usersService.getAllUsers();
//        List<UsersDTO> usersDTO = new ArrayList<>();
//        for (User user : users){
//            usersDTO.add(mapper.convertToDTO(user));
//        }
//        return ResponseEntity.ok(usersDTO);
//    }
//
//    @PutMapping("/{userId}")
//    public ResponseEntity<UsersDTO> updateUser(@PathVariable Integer userId, @Valid @RequestBody User user) throws UserNotFoundException {
//        User updatedUser = usersService.updateUser(userId, user);
//        return ResponseEntity.ok(mapper.convertToDTO(updatedUser));
//    }
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
//        usersService.deleteUser(userId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
