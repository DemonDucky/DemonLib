package me.demonducky.demonlib.listeners

import me.demonducky.demonlib.gui.MenuSystem
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent

class MenuListener : Listener {

    @EventHandler
    fun onCustomMenuClick(e: InventoryClickEvent) {

        val holder = (e.view.topInventory.holder as? MenuSystem) ?: return

        if (e.clickedInventory?.holder is MenuSystem) e.isCancelled = true


        holder.menuHandler(e)

    }

    @EventHandler
    fun onCustomMenuDrag(e: InventoryDragEvent) {

        val holder = (e.view.topInventory.holder as? MenuSystem) ?: return

        val listSlot = e.rawSlots
        val customMenuSize = e.view.topInventory.size
        val findSlot = listSlot.find { it < customMenuSize }

        if (findSlot != null) {
            e.isCancelled = true
        }

    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onCustomMenuShiftClick(e: InventoryClickEvent) {

        val holder = (e.view.topInventory.holder as? MenuSystem) ?: return

        if (e.action == InventoryAction.MOVE_TO_OTHER_INVENTORY) e.isCancelled = true


    }
}