package com.example.stage4e.Repository;

import com.example.stage4e.Entities.SignalPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.misc.Signal;

@Repository
public interface SignalRepository extends JpaRepository<SignalPost,Integer> {
}
