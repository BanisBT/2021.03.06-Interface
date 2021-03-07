package org.example.Service;

import org.example.Exception.NoEmployerInDb;
import org.example.Modul.Employer;

public interface EmployersDbManager {
    public void addEmployerToDb(Employer employer);

    public Employer findEmployerFromDbByName(String name) throws NoEmployerInDb;
}
