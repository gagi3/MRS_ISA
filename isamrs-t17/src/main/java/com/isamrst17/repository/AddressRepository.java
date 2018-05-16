package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Address;
import com.isamrst17.model.City;

public interface AddressRepository extends JpaRepository<Address, Long> {

  public List<Address> findByCity(City city);

}
