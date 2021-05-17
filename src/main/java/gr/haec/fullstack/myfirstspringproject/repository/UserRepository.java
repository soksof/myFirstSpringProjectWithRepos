package gr.haec.fullstack.myfirstspringproject.repository;

import gr.haec.fullstack.myfirstspringproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
