package ru.vegas.shoplist.domain.usecases

import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}