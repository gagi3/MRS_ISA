package com.isamrst17.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Rating;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.User;

public interface RatingRepository extends JpaRepository<Rating, Long> {

  public List<Rating> findByShow(Show show);
  public List<Rating> findByScreening(Screening screening);
  public List<Rating> findByPublicationDate(Date publicationDate);
  public List<Rating> findByUser(User user);

}
