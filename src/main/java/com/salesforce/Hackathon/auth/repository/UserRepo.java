package com.salesforce.Hackathon.auth.repository;

import com.salesforce.Hackathon.auth.dto.response.CustomUserResponseDTO;
import com.salesforce.Hackathon.auth.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long > {

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<CustomUserResponseDTO> findUserProjectionById(@Param("userId") Long userId);

    @Query("""
            SELECT u FROM User u where u.username=:username
            """)
    User findByUsername(String username);

    @EntityGraph( attributePaths = { "roles" } )
    User findByUsernameOrEmail(String username, String email );
    @Query("""
        SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))
       """)
   List<CustomUserResponseDTO> searchByUsername(String username );

    boolean existsByEmail( String email );

    @EntityGraph( attributePaths = { "roles" } )
    @Query( """
                SELECT
                    user
                FROM
                    User user
                WHERE
                    user.id = :id
            """ )
    CustomUserResponseDTO findUserByUserId(@Param( "id" ) Long id );


}
