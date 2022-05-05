package br.com.moonbox.moonboxservice.box.repository;

import br.com.moonbox.moonboxservice.box.repository.Box;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoxRepository {

    @Options(useGeneratedKeys = true)
    @Insert(value = "INSERT INTO boxes (id, name, description, sale_price) " +
            "VALUES (#{id}, #{name}, #{description}, #{salePrice});")
    void save(Box box);

    @Select("SELECT * FROM boxes WHERE id = #{id};")
    Box findById(int id);

    @Select("SELECT * FROM boxes;")
    List<Box> findAll();
}
