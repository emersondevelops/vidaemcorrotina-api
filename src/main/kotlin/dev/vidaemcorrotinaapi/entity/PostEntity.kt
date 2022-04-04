package dev.vidaemcorrotinaapi.entity

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "posts")
class PostEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var text: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,
    var active: Boolean = true
)
