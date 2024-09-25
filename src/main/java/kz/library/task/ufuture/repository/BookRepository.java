package kz.library.task.ufuture.repository;

import kz.library.task.ufuture.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
