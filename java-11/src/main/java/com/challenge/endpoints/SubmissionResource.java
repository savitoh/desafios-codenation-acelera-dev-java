package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionResource {

    private final SubmissionServiceInterface submissionServiceInterface;

    private final SubmissionMapper submissionMapper;

    public SubmissionResource(SubmissionServiceInterface submissionServiceInterface, SubmissionMapper submissionMapper) {
        this.submissionServiceInterface = submissionServiceInterface;
        this.submissionMapper = submissionMapper;
    }

    @GetMapping
    public List<Submission> getSubmission(@RequestParam("challengeId") Long challengeId,
                                          @RequestParam("accelerationId") Long accelerationId) {
        return submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}
