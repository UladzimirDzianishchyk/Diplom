package com.dzianishchyk.diplom.resource;

import com.dzianishchyk.diplom.config.jwt.JwtProvider;
import com.dzianishchyk.diplom.entity.AuthRequest;
import com.dzianishchyk.diplom.entity.AuthResponse;
import com.dzianishchyk.diplom.entity.RegistrationRequest;
import com.dzianishchyk.diplom.entity.User;
import com.dzianishchyk.diplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody  RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }
}
