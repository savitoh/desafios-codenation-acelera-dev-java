package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeResource {

    private final ChallengeServiceInterface challengeServiceInterface;

    public ChallengeResource(ChallengeServiceInterface challengeServiceInterface) {
        this.challengeServiceInterface = challengeServiceInterface;
    }

    @GetMapping
    public List<Challenge> getChallengeByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
                                                                 @RequestParam("userId") Long userId) {
        return challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
