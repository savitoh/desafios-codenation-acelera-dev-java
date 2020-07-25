package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserServiceInterface userServiceInterface;

    public UserResource(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userServiceInterface.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserByAccelerationNameOrCompanyId(
            @RequestParam(value = "accelerationName", required = false) String accelerationName,
            @RequestParam(value = "companyId", required = false) Long companyId) {

        if(Objects.nonNull(accelerationName)) {
            return ResponseEntity.ok(userServiceInterface.findByAccelerationName(accelerationName));
        }
        if(Objects.nonNull(companyId)) {
            return ResponseEntity.ok(userServiceInterface.findByCompanyId(companyId));
        }
        return ResponseEntity.badRequest().build();
    }
}
