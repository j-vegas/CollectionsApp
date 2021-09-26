package ru.vegas.shoplist.domain

sealed interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItemId: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>
}