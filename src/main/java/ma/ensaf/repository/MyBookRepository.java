package ma.ensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensaf.model.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
