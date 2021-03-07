package org.example.Service;

import org.example.Exception.NoEmployerInDb;
import org.example.Modul.Employer;

import java.util.List;

public interface LikesManager {
    public int allLikesOfEmployers(List<Employer> employersList);

    public void giveLike(String name) throws NoEmployerInDb;

    public int likesOfEmployer(String name) throws NoEmployerInDb;

}
