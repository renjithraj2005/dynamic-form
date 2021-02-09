package com.demo.form.repository;

import com.demo.form.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,Integer> {
}
