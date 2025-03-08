package com.Ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Ecommerce.dto.AuthRequest;
import com.Ecommerce.dto.AuthResponse;
import com.Ecommerce.exception.InvalidCredentialsException;
import com.Ecommerce.exception.UserAlreadyExistsException;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.UserRepository;
import com.Ecommerce.security.JwtUtil;

@Service
@RequiredArgsConstructor
@Slf4j 
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // User Registration
    public AuthResponse registerUser(AuthRequest request) {
        log.info("📌 User registration attempt: {}", request.getEmail()); 

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("⚠️ User already exists with this email!");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); 

        userRepository.save(user);
        return new AuthResponse(null, "✅ User registered successfully!");
    }

    // User Login
    public AuthResponse loginUser(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("❌ Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("❌ Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, "✅ User authenticated successfully!");
    }
}
