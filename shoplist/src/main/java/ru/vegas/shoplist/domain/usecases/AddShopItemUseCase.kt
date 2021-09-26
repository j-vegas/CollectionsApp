package ru.vegas.shoplist.domain.usecases

import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}