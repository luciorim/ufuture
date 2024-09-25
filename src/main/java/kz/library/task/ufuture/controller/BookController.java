package kz.library.task.ufuture.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import kz.library.task.ufuture.dto.request.BookRequestDto;
import kz.library.task.ufuture.dto.response.BookResponseDto;
import kz.library.task.ufuture.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity
                .ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieve a specific book by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public ResponseEntity<BookResponseDto> getBookById(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity
                .ok(bookService.getBookById(id));
    }


    @PostMapping
    @Operation(summary = "Create new book", description = "Create a new book with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BookResponseDto> createBook(
            @Valid @RequestBody BookRequestDto bookRequestDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.createBook(bookRequestDto));
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update book", description = "Update the details of an existing book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data or ID"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable("id") UUID id,
            @Valid @RequestBody BookRequestDto bookRequestDto
    ) {
        return ResponseEntity
                .ok(bookService.updateBook(id, bookRequestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book", description = "Delete a specific book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted the book"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public ResponseEntity<Void> deleteBook(
            @PathVariable("id") UUID id
    ) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
