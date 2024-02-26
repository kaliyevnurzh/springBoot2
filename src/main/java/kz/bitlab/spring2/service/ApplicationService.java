package kz.bitlab.spring2.service;

import kz.bitlab.spring2.model.Application;
import kz.bitlab.spring2.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public void addApplication(Application application) {
        applicationRepository.save(application);
    }

    public Application getApplication(int id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public void updateApplication(Application application) {
        applicationRepository.save(application);
    }

    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    public List<Application> getApplicationsByHandled(boolean handled) {
        return applicationRepository.findApplicationsByHandled(handled);
    }
}
