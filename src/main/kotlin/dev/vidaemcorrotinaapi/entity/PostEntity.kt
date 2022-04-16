package dev.vidaemcorrotinaapi.entity

import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID
import java.util.UUID.randomUUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "posts")
class PostEntity(
    @Id
    val id: UUID = randomUUID(),
    var title: String,
    var text: String,
    @ManyToOne
    val author: UserEntity,
    var createdAt: LocalDateTime = now(),
    var updatedAt: LocalDateTime? = null,
    var active: Boolean = true
)
