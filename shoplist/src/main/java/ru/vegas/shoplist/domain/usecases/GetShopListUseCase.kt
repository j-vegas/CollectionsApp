package ru.vegas.shoplist.domain.usecases

import ru.vegas.shoplist.domain.ShopItem
import ru.vegas.shoplist.domain.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}