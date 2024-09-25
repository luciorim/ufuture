package kz.library.task.ufuture.service;

import kz.library.task.ufuture.dto.request.BookRequestDto;
import kz.library.task.ufuture.dto.response.BookResponseDto;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(UUID id);
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    BookResponseDto updateBook(UUID id, BookRequestDto bookRequestDto);
    void deleteBook(UUID id);
}
