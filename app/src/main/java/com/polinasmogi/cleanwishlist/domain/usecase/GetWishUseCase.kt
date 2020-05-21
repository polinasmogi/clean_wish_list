package com.polinasmogi.cleanwishlist.domain.usecase

import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.domain.repository.WishesRepository
import kotlinx.coroutines.flow.Flow

class GetWishUseCase(private val repo: WishesRepository) {

    fun execute(): Flow<List<Wish>> {
        return repo.getWishes()
    }
}