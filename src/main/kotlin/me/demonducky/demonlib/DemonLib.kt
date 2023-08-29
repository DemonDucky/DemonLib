package me.demonducky.demonlib

import me.demonducky.demonlib.listeners.MenuListener
import org.bukkit.plugin.java.JavaPlugin

class DemonLib : JavaPlugin() {
    override fun onEnable() {

        server.pluginManager.registerEvents(MenuListener(), this)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
