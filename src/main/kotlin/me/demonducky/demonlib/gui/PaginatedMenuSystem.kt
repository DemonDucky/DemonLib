package me.demonducky.demonlib.gui

import me.demonducky.demonlib.utils.PlayerMenuUtils
import kotlin.math.ceil

abstract class PaginatedMenuSystem(p: PlayerMenuUtils) : MenuSystem(p) {

    private var currentPage = 0
    var firstPageMessage = "You're in first page"
    var lastPageMessage = "You're in last page"
    var maxSlotsPerPage = 0
    var dataAmount = 0

    open fun prevPage() {
        if (currentPage >= 0) {

            currentPage - 1
            open()

        } else p.e.sendMessage(firstPageMessage)
    }

    open fun nextPage() {
        if (currentPage < ceil((dataAmount / maxSlotsPerPage).toDouble())) {

            currentPage + 1
            open()

        } else p.e.sendMessage(lastPageMessage)
    }

}