package org.example.Service;

import org.example.Exception.NoEmployerInDb;
import org.example.Modul.Employer;

import java.util.ArrayList;
import java.util.List;

public class EmployersDbManagerImpl implements EmployersDbManager {
    private List<Employer> employersDb;

    public EmployersDbManagerImpl() {
        employersDb = new ArrayList<>();
    }

    @Override
    public void addEmployerToDb(Employer employer) {
        employersDb.add(employer);
    }

    @Override
    public Employer findEmployerFromDbByName(String name) throws NoEmployerInDb {
        for (Employer employer : employersDb) {
            if (employer.getName().equals(name)) {
                return employer;
            }
        }
        throw new NoEmployerInDb();
    }

    public List<Employer> getEmployersDb() {
        return employersDb;
    }
}
