package me.demonducky.demonlib.utils

import org.apache.commons.lang.StringUtils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.YamlConfiguration

object MessageUtils {

    fun sendMessage(sender: CommandSender, message: String?) {

        sender.sendMessage(formatMessage(message))

    }

    fun broadcastMessage(message: String, payload: Map<String, String> = mapOf()) {


        Bukkit.broadcastMessage(formatMessage(message, payload))
    }

    fun getMessage(path: String, config: YamlConfiguration): List<String> {

        val stringListMessage = config.getStringList(path)

        return if (stringListMessage.isEmpty()) listOf(config.getString(path) ?: "") else stringListMessage
    }


    private fun formatMessage(message: String?, payload: Map<String, String> = mapOf(), color: Boolean = true): String {

        val placeholders = payload.keys.map { key -> "%${key}%" }.toTypedArray()

        val replacedString = StringUtils.replaceEach(message, placeholders, payload.values.toTypedArray())

        return if (color) ChatColor.translateAlternateColorCodes('&', replacedString) else replacedString

    }

    fun messageBuild(args: Array<out String>, startFrom: Int, end: Int): String {
        return args.slice(startFrom .. end).joinToString(" ")
    }

}