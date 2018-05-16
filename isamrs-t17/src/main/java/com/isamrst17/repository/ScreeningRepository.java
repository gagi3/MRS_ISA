package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Theatre;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

  public List<Screening> findByShow(Show show);
  public List<Screening> findByTheatre(Theatre theatre);

}
