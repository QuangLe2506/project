package vn.com.devmaster.services.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.domain.enums.RoleEnum;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u " +
            " where u.fullName like concat('%',:keyword,'%') " +
            " or u.email like concat('%',:keyword, '%') " )
    Page<User> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "select u from User u where u.role = :role")
    Optional<User> findByRole(@Param("role") RoleEnum role);

    Optional<User> findByAccount(String account);
}