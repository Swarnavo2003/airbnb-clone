package in.swarnavo.airbnb.security;

import in.swarnavo.airbnb.dto.SignUpRequestDto;
import in.swarnavo.airbnb.dto.UserDto;
import in.swarnavo.airbnb.entity.User;
import in.swarnavo.airbnb.entity.enums.Role;
import in.swarnavo.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        User user = userRepository
                .findByEmail(signUpRequestDto.getEmail())
                .orElse(null);

        if(user != null) {
            throw new RuntimeException("User already present with same email id");
        }

        User newUser = modelMapper.map(signUpRequestDto, User.class);
        newUser.setRoles(Set.of(Role.GUEST));
        newUser.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        newUser = userRepository.save(newUser);

        return modelMapper.map(newUser, UserDto.class);
    }
}
