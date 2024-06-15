package org.hygorm10.bookstore.repositories

import org.hygorm10.bookstore.models.BookModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface BookRepository : JpaRepository<BookModel, UUID> {

    fun findBookModelByTitle(title: String): BookModel

    @Query(value = "SELECT * FROM tb_book WHERE publisher.id = :publisherId", nativeQuery = true)
    fun findBooksByPublisherId(publisherId: UUID): List<BookModel>

}