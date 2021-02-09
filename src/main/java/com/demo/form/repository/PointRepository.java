package com.demo.form.repository;

import com.demo.form.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point,Integer> {
}
