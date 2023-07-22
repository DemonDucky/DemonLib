package me.demonducky.demonlib.gui

import me.demonducky.demonlib.items.ItemSystem
import me.demonducky.demonlib.utils.PlayerMenuUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

abstract class MenuSystem(val p: PlayerMenuUtils): InventoryHolder {

    private lateinit var inventory: Inventory
    val itemsList = listOf<ItemSystem>()
    override fun getInventory(): Inventory {
        return inventory
    }

    abstract fun getTitle(): String

    abstract fun getSlots(): Int

    abstract fun setMenuItems()

    open fun menuHandler(e: InventoryClickEvent) {

        val clickType = e.click
        val tasks = itemsList.find { it.getMenuItem() == e.currentItem } ?: return

        val runTask = tasks.tasks[clickType] ?: return

        runTask(e)

    }

    fun fillBlank(material: Material) {
        for (i in 0 until getSlots()) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, ItemStack(material))
        }
    }

    fun open() {
        inventory = Bukkit.createInventory(this, getSlots(), getTitle())

        p.e.openInventory(inventory)

    }
}