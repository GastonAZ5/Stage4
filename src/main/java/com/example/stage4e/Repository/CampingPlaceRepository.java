package com.example.stage4e.Repository;

import com.example.stage4e.Entities.CampingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingPlaceRepository extends JpaRepository<CampingPlace,Integer> {

}
