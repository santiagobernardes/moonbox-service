package br.com.moonbox.moonboxservice.auth.repository;

import br.com.moonbox.moonboxservice.auth.model.User;
import br.com.moonbox.moonboxservice.customer.repository.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {

    @Options(useGeneratedKeys = true)
    @Insert(value = "INSERT INTO users (id, first_name, last_name, birth_date, email, password, role) " +
            "VALUES (#{id}, #{firstName}, #{lastName}, #{birthDate}, #{email}, #{password}, #{role});")
    void save(User user);

    @Select("SELECT * FROM users u WHERE u.email = #{email};")
    User findByEmail(String email);

    @Select("SELECT EXISTS(SELECT email FROM users u WHERE u.email = #{email})")
    Integer existsByEmail(String email);
}
