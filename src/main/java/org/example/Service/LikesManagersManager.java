package org.example.Service;

import org.example.Modul.Employer;

import java.util.List;

import static org.example.Modul.EmployersRole.PROJECT_MANAGER;

public class LikesManagersManager extends LikesManagerImpl {

    @Override
    public int allLikesOfEmployers(List<Employer> employersList) {
        int sumLikesOfManagers = 0;

        for (Employer employer : employersList) {
            if (employer.getRole().equals(PROJECT_MANAGER)) {
                employer.setLikes(employer.getLikes() + 1);
            }
        }
        return sumLikesOfManagers;
    }
}
