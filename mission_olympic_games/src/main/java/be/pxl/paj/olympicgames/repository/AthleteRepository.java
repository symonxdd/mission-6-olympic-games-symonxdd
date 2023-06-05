package be.pxl.paj.olympicgames.repository;

import be.pxl.paj.olympicgames.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
