package Valorya.box.Service;
import org.springframework.security.core.userdetails.User;



import Valorya.box.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User salvarUsuario(User user) {
            return userRepository.save(user);
        }

        public List<User> listarUsuarios() {
            return userRepository.findAll();
        }

        public Optional<User> buscarPorId(Long id) {
            return userRepository.findById(id);
        }

        public void deletarUsuario(Long id) {
            userRepository.deleteById(id);
        }

        public Optional<User> buscarPorEmail(String email) {
            return userRepository.findByEmail(email);
        }
    }