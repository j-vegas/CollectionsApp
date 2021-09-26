package ru.vegas.shoplist.domain.usecases

import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItemId: ShopItem) {
        shopListRepository.deleteShopItem(shopItemId)
    }
}