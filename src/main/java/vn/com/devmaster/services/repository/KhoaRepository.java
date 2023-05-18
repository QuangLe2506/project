package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.services.domain.Khoa;
@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {
}
