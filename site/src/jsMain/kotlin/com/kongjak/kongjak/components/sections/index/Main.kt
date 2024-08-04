package com.kongjak.kongjak.components.sections.index

import androidx.compose.runtime.Composable
import com.kongjak.kongjak.components.widgets.TextTooltip
import com.kongjak.kongjak.utils.GITHUB_URL
import com.kongjak.kongjak.utils.MAIL_ADDRESS
import com.kongjak.kongjak.utils.TELEGRAM_URL
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaPaperPlane
import com.varabyte.kobweb.silk.components.icons.fa.IconSize.LG
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle.FILLED
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@Composable
fun IndexMain() {
    Column(
        modifier = Modifier.fillMaxSize().minWidth(100.percent).minHeight(100.vh).id("main"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H3(attrs = Modifier.margin(0.percent).toAttrs()) {
            Text("Kongjak")
        }
        Row {
            Link(TELEGRAM_URL, Modifier.margin(8.px).color(Colors.White)) {
                FaPaperPlane(size = LG, style = FILLED)
            }
            TextTooltip("Telegram")

            Link(GITHUB_URL, Modifier.margin(8.px).color(Colors.White)) {
                FaGithub(size = LG)
            }
            TextTooltip("GitHub")

            Link(MAIL_ADDRESS, Modifier.margin(8.px).color(Colors.White)) {
                FaEnvelope(size = LG, style = FILLED)
            }
            TextTooltip("Email")
        }
    }
}