package com.repository;

import com.models.BulkRNA;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BulkRNARepository extends JpaRepository<BulkRNA, Long> {
    List<BulkRNA> findAllByUser(User user);
}
