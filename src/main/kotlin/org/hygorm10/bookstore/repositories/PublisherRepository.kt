package org.hygorm10.bookstore.repositories

import org.hygorm10.bookstore.models.PublisherModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PublisherRepository : JpaRepository<PublisherModel, UUID> {
}