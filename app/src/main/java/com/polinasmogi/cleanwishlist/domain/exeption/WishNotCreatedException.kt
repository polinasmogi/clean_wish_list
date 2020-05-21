package com.polinasmogi.cleanwishlist.domain.exeption

import java.lang.Exception

class WishNotCreatedException(override val message: String?) : Exception(message)