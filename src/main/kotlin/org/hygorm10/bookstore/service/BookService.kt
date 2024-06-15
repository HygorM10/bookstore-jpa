package org.hygorm10.bookstore.service

import jakarta.transaction.Transactional
import org.hygorm10.bookstore.dtos.BookRecordDto
import org.hygorm10.bookstore.models.BookModel
import org.hygorm10.bookstore.models.ReviewModel
import org.hygorm10.bookstore.repositories.AuthorRepository
import org.hygorm10.bookstore.repositories.BookRepository
import org.hygorm10.bookstore.repositories.PublisherRepository
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.stream.Collectors

@Service
class BookService(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository,
    val publisherRepository: PublisherRepository,
) {

    @Transactional
    fun saveBook(bookRecordDto: BookRecordDto): BookModel {
        val book = BookModel(
            title = bookRecordDto.title,
            publisher = publisherRepository.findById(bookRecordDto.publisherId).get(),
            authors = authorRepository.findAllById(bookRecordDto.authorIds).stream().collect(Collectors.toSet()),
        )

        val reviewModel = ReviewModel(
            comment = bookRecordDto.reviewComment,
            book = book,
        )
        book.review = reviewModel

        return bookRepository.save(book)
    }

    fun getAllBooks(): List<BookModel> = bookRepository.findAll()

    @Transactional
    fun deleteBook(id: UUID) = bookRepository.deleteById(id)

}