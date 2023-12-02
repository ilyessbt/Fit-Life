package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Coach;
import com.example.fitlife.repository.CoachRepo;
import com.example.fitlife.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CoachServiceImp implements CoachService {
    @Autowired
    private CoachRepo coachRepository;
    @Override
    public Coach findById(Long coachId) {
        return coachRepository.findById(coachId)
                .orElseThrow(() -> new NoSuchElementException("Coach not found with ID: " + coachId));
    }

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }
    @Override
    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Long countCoach() {
        return coachRepository.count();
    }

    @Override
    public void deleteCoach(Long coachId) {
        coachRepository.deleteById(coachId);
    }


    @Override
    public Coach updateCoachPartial(Long coachId, Coach updatedCoach) {
        Optional<Coach> existingCoachOptional = coachRepository.findById(coachId);

        if (existingCoachOptional.isPresent()) {
            Coach existingCoach = existingCoachOptional.get();

            if (updatedCoach.getFirstName() != null) {
                existingCoach.setFirstName(updatedCoach.getFirstName());
            }

            if (updatedCoach.getLastName() != null) {
                existingCoach.setLastName(updatedCoach.getLastName());
            }

            if (updatedCoach.getAge() != 0) {
                existingCoach.setAge(updatedCoach.getAge());
            }

            return coachRepository.save(existingCoach);
        } else {
            return null;
        }
    }

}
