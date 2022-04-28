package Multicampus.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }
    @RequestMapping(value = "/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    @RequestMapping(value="/users", produces = { "application/json" })
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
//return ResponseEntity.ok(user);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(userDetail.getName());
        user.setEmail(userDetail.getEmail());
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }
}
