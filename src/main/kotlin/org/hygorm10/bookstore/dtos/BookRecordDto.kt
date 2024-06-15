package org.hygorm10.bookstore.dtos

import java.util.UUID

data class BookRecordDto(
    val title: String,
    val publisherId: UUID,
    val authorIds: Set<UUID>,
    val reviewComment: String,
)
