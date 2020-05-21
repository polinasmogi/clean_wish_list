package com.polinasmogi.cleanwishlist.domain.usecase

import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.domain.exeption.WishNotDeletedException
import com.polinasmogi.cleanwishlist.domain.repository.WishesRepository

class DeleteWishUseCase(private val repository: WishesRepository) {

    suspend fun execute(wish: Wish) {
        require(wish.id > 0) { "Wish does not have a valid Id" }

        val deleted = repository.delete(wishId = wish.id)

        if (!deleted) throw WishNotDeletedException("Wish could not be deleted")

    }

}