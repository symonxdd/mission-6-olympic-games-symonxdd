package be.pxl.paj.olympicgames.repository;

import be.pxl.paj.olympicgames.domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

}
