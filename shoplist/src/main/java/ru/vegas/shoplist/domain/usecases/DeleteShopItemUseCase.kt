package ru.vegas.shoplist.domain.usecases

import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}