package antifraud.service;

import antifraud.dto.UserEntityDTO;
import antifraud.model.User;
import antifraud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntityDTO registerUser(User user) {
        userRepository.save(user);
        return new UserEntityDTO();
    }

}
