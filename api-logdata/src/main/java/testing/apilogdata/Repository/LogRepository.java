package testing.apilogdata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testing.apilogdata.Entity.Logs;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Logs, Long> {
    List<Logs> findByUser(String user);
}
