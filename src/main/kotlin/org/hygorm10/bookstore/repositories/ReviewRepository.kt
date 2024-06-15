package org.hygorm10.bookstore.repositories

import org.hygorm10.bookstore.models.ReviewModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewRepository : JpaRepository<ReviewModel, UUID> {
}