package com.polinasmogi.cleanwishlist.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.domain.logger.Logger
import com.polinasmogi.cleanwishlist.domain.usecase.CreateWishUseCase
import com.polinasmogi.cleanwishlist.domain.usecase.DeleteWishUseCase
import com.polinasmogi.cleanwishlist.domain.usecase.GetWishUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import java.security.interfaces.RSAMultiPrimePrivateCrtKey
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class WishViewModel(
    private val createWishUseCase: CreateWishUseCase,
    private val deleteWishUseCase: DeleteWishUseCase,
    private val getWishUseCase: GetWishUseCase,
    private val logger: Logger
) : ViewModel(), CoroutineScope {

    private val _wishes = MutableLiveData<List<Wish>>()
    val wishes: LiveData<List<Wish>> = _wishes


    private val TAG = "WishViewModel"

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
            logger.e(TAG, "Error on coroutine", throwable)
        }

    init {
        launch {
            getWishUseCase.execute()
                .catch { logger.d(TAG, "$it") }
                .collect { _wishes.postValue(it) }
        }
    }

    override fun onCleared() {
        coroutineContext.cancel()
    }

    fun create(title: String, price: Double) {
        launch {
            createWishUseCase.execute(title, price)
        }
    }

    fun delete(wish: Wish) {
        launch {
            deleteWishUseCase.execute(wish)
        }
    }


}