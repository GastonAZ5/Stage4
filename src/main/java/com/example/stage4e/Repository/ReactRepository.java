package com.example.stage4e.Repository;

import com.example.stage4e.Entities.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<React,Integer> {
}
