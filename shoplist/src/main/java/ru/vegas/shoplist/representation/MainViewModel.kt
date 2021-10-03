package ru.vegas.shoplist.representation

import androidx.lifecycle.ViewModel
import ru.vegas.shoplist.data.ShopListRepositoryImpl
import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.usecases.DeleteShopItemUseCase
import ru.vegas.shoplist.domain.usecases.EditShopItemUseCase
import ru.vegas.shoplist.domain.usecases.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
