package org.hygorm10.bookstore.repositories

import org.hygorm10.bookstore.models.AuthorModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AuthorRepository : JpaRepository<AuthorModel, UUID> {
}