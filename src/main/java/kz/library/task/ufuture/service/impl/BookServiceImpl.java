package kz.library.task.ufuture.service.impl;

import kz.library.task.ufuture.dto.request.BookRequestDto;
import kz.library.task.ufuture.dto.response.BookResponseDto;
import kz.library.task.ufuture.exception.DbRowNotFoundException;
import kz.library.task.ufuture.mapper.BookMapper;
import kz.library.task.ufuture.repository.BookRepository;
import kz.library.task.ufuture.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponseDto> getAllBooks() {
        log.info("Request to get all books");
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookResponseDto getBookById(UUID id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new DbRowNotFoundException(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Book not found"));

        log.info("Request to get book by id {}", id);
        return bookMapper.toDto(book);
    }

    @Override
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        var book = bookMapper.toEntity(bookRequestDto);

        bookRepository.save(book);

        log.info("Book created: {}", book);
        return bookMapper.toDto(book);
    }

    @Override
    public BookResponseDto updateBook(UUID id, BookRequestDto bookRequestDto) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new DbRowNotFoundException(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Book not found"));

        book.setAuthor(bookRequestDto.getAuthor());
        book.setTitle(bookRequestDto.getTitle());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());

        bookRepository.save(book);
        log.info("Book updated: {}", book);

        return bookMapper.toDto(book);
    }

    @Override
    public void deleteBook(UUID id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new DbRowNotFoundException(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Book not found"));

        bookRepository.delete(book);
        log.info("Book deleted: {}", book);
    }

}
