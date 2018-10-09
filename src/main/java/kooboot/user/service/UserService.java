package kooboot.user.service;

import kooboot.message.domain.RequestMessage;
import kooboot.user.domain.User;
import kooboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByRequestMessage(RequestMessage requestMessage) {
        return userRepository.findByUserKey(requestMessage.getUser_key()).orElse(User.valueOf(requestMessage));
    }

    public User save(User user){
        return userRepository.save(user);
    }


}
