package br.com.moonbox.moonboxservice.auth.repository;

import br.com.moonbox.moonboxservice.auth.model.Role;
import br.com.moonbox.moonboxservice.auth.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleRepository {
    @Select("SELECT * FROM roles r WHERE r.name = #{name};")
    Role findByName(String name);
}
