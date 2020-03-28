package com.momoapps.userservice.dao;

import com.momoapps.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.server.PathParam;
import java.util.List;

//@CrossOrigin("*")
//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    //@RestResource(path = "/findUser/{firstName}/{lastName}/{email}/{phoneNumber}")
    User findByFirstNameOrLastNameOrEmailOrPhoneNumberAllIgnoringCase(
            @Param("firstName") String firstName, @Param("lastName") String lastName,
            @Param("email") String email, @Param("phoneNumber") String phoneNumber
    );

    @Query(value = "SELECT u "
            + "FROM User u "
            + "WHERE u.firstName like %:keyword%  or u.lastName like %:keyword% or u.email like %:keyword% "
            + "or u.phoneNumber like %:keyword%"
    )
    List<User> findUsersByKeywordAllIgnoringCase(@Param("keyword") String keyword);


    User findByFirstNameAndLastNameAndEmailAndPhoneNumberAllIgnoringCase(
            @Param("firstName") String firstName, @Param("lastName") String lastName,
            @Param("email") String email, @Param("phoneNumber") String phoneNumber
    );
}
