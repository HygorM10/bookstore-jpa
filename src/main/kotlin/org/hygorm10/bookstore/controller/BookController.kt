package org.hygorm10.bookstore.controller

import org.hygorm10.bookstore.dtos.BookRecordDto
import org.hygorm10.bookstore.models.BookModel
import org.hygorm10.bookstore.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/bookstore/books")
class BookController(
    val bookService: BookService
) {

    @PostMapping
    fun saveBook(@RequestBody bookRecordDto: BookRecordDto): ResponseEntity<BookModel> {
        return ResponseEntity.status(201).body(bookService.saveBook(bookRecordDto))
    }

    @GetMapping
    fun getAllBooks() = ResponseEntity.ok().body(bookService.getAllBooks())

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: UUID) = ResponseEntity.status(204).body(bookService.deleteBook(id))
}