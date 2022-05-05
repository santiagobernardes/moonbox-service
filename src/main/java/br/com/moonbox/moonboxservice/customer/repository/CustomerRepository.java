package br.com.moonbox.moonboxservice.customer.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerRepository {

    @Options(useGeneratedKeys = true)
    @Insert(value = "INSERT INTO customers (id, first_name, last_name, birth_date, email) " +
            "VALUES (#{id}, #{firstName}, #{lastName}, #{birthDate}, #{email});")
    void save(Customer customer);

    @Select("SELECT " +
            "id as id, " +
            "first_name as firstName, " +
            "last_name as lastName, " +
            "birth_date as birthDate, " +
            "email as email " +
            "FROM customers;")
    List<Customer> findAll();
}
