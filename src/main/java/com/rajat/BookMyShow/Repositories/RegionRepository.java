package com.rajat.BookMyShow.Repositories;

import com.rajat.BookMyShow.Models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
