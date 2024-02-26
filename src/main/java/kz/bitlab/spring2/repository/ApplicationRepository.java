package kz.bitlab.spring2.repository;

import kz.bitlab.spring2.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findApplicationsByHandled(boolean handled);
}
