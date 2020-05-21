package com.polinasmogi.cleanwishlist.domain.exeption

import java.lang.Exception

class WishNotDeletedException(override val message: String?) : Exception(message)