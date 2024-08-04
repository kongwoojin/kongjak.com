package com.kongjak.kongjak.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.kongjak.kongjak.components.sections.Footer
import com.varabyte.kobweb.compose.foundation.layout.Arrangement.Center
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Alignment.CenterHorizontally
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PageContentStyle = CssStyle.base {
    Modifier.fillMaxHeight().width(75.percent).padding(leftRight = 16.px)
}

@Composable
fun PageLayout(title: String, content: @Composable ColumnScope.() -> Unit) {
    LaunchedEffect(title) {
        document.title = "Kongjak - $title"
    }

    Box(
        Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            .backgroundColor(Color.rgb(18, 18, 18))
            .gridTemplateRows { size(1.fr); size(minContent) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxSize().gridRow(1),
            horizontalAlignment = CenterHorizontally
        ) {
            Column(
                modifier = PageContentStyle.toModifier(),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Center
            ) {
                content()
            }
            Footer(modifier = PageContentStyle.toModifier())
        }
    }
}
