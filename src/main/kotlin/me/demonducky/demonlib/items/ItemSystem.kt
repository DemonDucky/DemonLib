package me.demonducky.demonlib.items

import org.bukkit.enchantments.Enchantment
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class ItemSystem(
    val item: ItemStack,
    val slots: Int,
    val bright: Boolean = false,
    val tasks: Map<ClickType, (InventoryClickEvent) -> Unit> = mapOf()
) {

    private val itemMeta = item.itemMeta

    fun setBright() {
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 1)
        itemMeta?.addItemFlags(ItemFlag.HIDE_ENCHANTS)
    }

    fun getMenuItem(): ItemStack {
        if (bright) setBright()
        item.itemMeta = itemMeta
        return item
    }
}