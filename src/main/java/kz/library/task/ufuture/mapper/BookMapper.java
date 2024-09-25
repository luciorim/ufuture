package kz.library.task.ufuture.mapper;

import kz.library.task.ufuture.dto.request.BookRequestDto;
import kz.library.task.ufuture.dto.response.BookResponseDto;
import kz.library.task.ufuture.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequestDto bookRequestDto) {
        return Book.builder()
                .title(bookRequestDto.getTitle())
                .price(bookRequestDto.getPrice())
                .author(bookRequestDto.getAuthor())
                .description(bookRequestDto.getDescription())
                .build();
    }

    public BookResponseDto toDto(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(book.getAuthor())
                .description(book.getDescription())
                .build();
    }

}
