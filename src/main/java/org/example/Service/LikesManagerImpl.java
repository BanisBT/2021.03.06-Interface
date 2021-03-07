package org.example.Service;

import org.example.Exception.NoEmployerInDb;
import org.example.Modul.Employer;

public abstract class LikesManagerImpl extends EmployersDbManagerImpl implements LikesManager {
    @Override
    public void giveLike(String name) throws NoEmployerInDb {
        Employer employerPlusLike = findEmployerFromDbByName(name);
        employerPlusLike.setLikes(employerPlusLike.getLikes() + 1);
    }

    @Override
    public int likesOfEmployer(String name) throws NoEmployerInDb {
        Employer employersLikes = findEmployerFromDbByName(name);
        return employersLikes.getLikes();
    }
}
