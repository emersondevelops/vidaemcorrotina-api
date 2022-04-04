package dev.vidaemcorrotinaapi.repository

import dev.vidaemcorrotinaapi.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository: JpaRepository<PostEntity, UUID> {
}