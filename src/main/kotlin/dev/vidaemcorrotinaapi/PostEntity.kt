package dev.vidaemcorrotinaapi

import java.util.UUID
import java.util.UUID.randomUUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "posts")
class PostEntity(
    @Id
    val id: UUID = randomUUID(),
    var title: String,
    var text: String
)