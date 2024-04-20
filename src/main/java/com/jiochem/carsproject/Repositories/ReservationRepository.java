package com.jiochem.carsproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jiochem.carsproject.Models.Voiture;

@Repository
public interface ReservationRepository extends CrudRepository<Voiture, Long> {
}
