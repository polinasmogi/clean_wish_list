package com.polinasmogi.cleanwishlist.domain.usecase

import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.domain.exeption.WishNotCreatedException
import com.polinasmogi.cleanwishlist.domain.repository.WishesRepository

class CreateWishUseCase(private val repository: WishesRepository) {

    suspend fun execute(title: String, price: Double) {

        require(title.isNotBlank()) { "Wish title must not be blank" }

        val wishToStore = Wish(id = 0, title = title.capitalize(), price = price)
        val id = repository.create(wishToStore)

        if (id <= 0) throw WishNotCreatedException("Wish could not be saved")

    }

}