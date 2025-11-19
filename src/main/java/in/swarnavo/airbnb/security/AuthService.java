package in.swarnavo.airbnb.security;

import in.swarnavo.airbnb.dto.LoginDto;
import in.swarnavo.airbnb.dto.SignUpRequestDto;
import in.swarnavo.airbnb.dto.UserDto;
import in.swarnavo.airbnb.entity.User;
import in.swarnavo.airbnb.entity.enums.Role;
import in.swarnavo.airbnb.exception.ResourceNotFoundException;
import in.swarnavo.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        User user = userRepository
                .findByEmail(signUpRequestDto.getEmail())
                .orElse(null);

        if(user != null) {
            throw new RuntimeException("User already present with same email id");
        }

        User newUser = modelMapper.map(signUpRequestDto, User.class);

        Role selectedRole = (signUpRequestDto.getRole() != null)
                ? signUpRequestDto.getRole()
                : Role.GUEST;

        newUser.setRole(selectedRole);
        newUser.setRoles(Set.of(selectedRole));
        newUser.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        newUser = userRepository.save(newUser);

        return modelMapper.map(newUser, UserDto.class);
    }

    public String[] login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        User user = (User) authentication.getPrincipal();

        String[] tokens = new String[2];
        tokens[0] = jwtService.generateAccessToken(user);
        tokens[1] = jwtService.generateRefreshToken(user);

        return tokens;
    }

    public String refreshToken(String refreshToken) {
        Long id = jwtService.getUserIdFromToken(refreshToken);

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        return jwtService.generateAccessToken(user);
    }
}
