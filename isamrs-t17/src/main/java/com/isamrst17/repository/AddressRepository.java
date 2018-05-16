package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Address;
import com.isamrst17.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  public List<Address> findByCity(City city);

}
