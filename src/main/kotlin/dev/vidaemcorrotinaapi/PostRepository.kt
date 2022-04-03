package dev.vidaemcorrotinaapi

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository: JpaRepository<PostEntity, UUID> {
}