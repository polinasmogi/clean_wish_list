package com.polinasmogi.cleanwishlist.data.local.mapper

import com.polinasmogi.cleanwishlist.data.local.entity.WishEntity
import com.polinasmogi.cleanwishlist.domain.entity.Wish

private fun map(wishEntity: WishEntity) = Wish(
    id = wishEntity.id,
    title = wishEntity.title,
    price = wishEntity.price
)

fun WishEntity.toWish() = map(this)
fun List<WishEntity>.toWish() = map { it.toWish() }

private fun map(wish: Wish) = WishEntity(
    id = wish.id,
    title = wish.title,
    price = wish.price
)

fun Wish.toWishEntity() = map(this)
fun List<Wish>.toWishEntity() = map { it.toWishEntity() }