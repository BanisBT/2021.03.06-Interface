package org.example.Service;

import org.example.Modul.Employer;
import org.example.Modul.EmployersRole;

import java.util.List;

import static org.example.Modul.EmployersRole.*;

public class LikesDeveloperManager extends LikesManagerImpl {

    @Override
    public int allLikesOfEmployers(List<Employer> employersList) {
        int sumLikesOfDevelopers = 0;

        for (Employer employer : employersList) {
            if (employer.getRole().equals(JUNIOR_DEVELOPER) | employer.getRole().equals(MILD_DEVELOPER)
                    | employer.getRole().equals(SENIOR_DEVELOPER)) {
                sumLikesOfDevelopers += employer.getLikes();
            }
        }
        return sumLikesOfDevelopers;
    }
}
