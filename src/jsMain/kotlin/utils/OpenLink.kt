package utils

import kotlinx.browser.window
import org.w3c.dom.Window

fun openLink(link: String): Window? {
    return window.open(link, "_blank")
}