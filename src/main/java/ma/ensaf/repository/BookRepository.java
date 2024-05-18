package ma.ensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaf.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
