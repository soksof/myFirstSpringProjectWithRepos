package gr.haec.fullstack.myfirstspringproject.repository;

import gr.haec.fullstack.myfirstspringproject.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    public UserType findByType(String type);
}
