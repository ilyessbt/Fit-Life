package com.example.fitlife.service;

import com.example.fitlife.model.Coach;


import java.util.List;

public interface CoachService {
    Coach findById(Long id);
    List<Coach> getAllCoaches();
    Coach addCoach(Coach coach);
    void deleteCoach(Long coachId);
    Coach updateCoachPartial(Long coachId, Coach coach);

}
