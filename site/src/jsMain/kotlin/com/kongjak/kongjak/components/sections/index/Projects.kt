package com.kongjak.kongjak.components.sections.index

import androidx.compose.runtime.Composable
import com.kongjak.kongjak.components.widgets.TextTooltip
import com.kongjak.kongjak.models.ProjectUrl
import com.kongjak.kongjak.models.TechStack
import com.kongjak.kongjak.models.getFaIcon
import com.kongjak.kongjak.utils.DevIcon
import com.kongjak.kongjak.utils.projectLists
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.Text

val ProjectItemStyle = CssStyle {
    base {
        Modifier.margin(16.px).borderRadius(5.px).backgroundColor(Color.rgba(255F, 255F, 255F, 0.05F))
    }
}

@Composable
fun IndexProjects() {
    Column(
        modifier = Modifier.minWidth(100.percent).minHeight(100.vh).id("projects"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        H2 {
            Text("Projects")
        }

        SimpleGrid(modifier = Modifier.fillMaxWidth(), numColumns = numColumns(1, lg = 2, xl = 3)) {
            for (project in projectLists) {
                ProjectWidget(project.name, project.description, project.techStacks, project.urls)
            }
        }
    }
}

@Composable
fun ProjectWidget(
    name: String,
    description: String,
    techStacks: List<TechStack>,
    urls: List<ProjectUrl>
) {
    Box(
        modifier = ProjectItemStyle.toModifier()
    ) {
        Column(
            modifier = Modifier.padding(16.px).fillMaxSize()
        ) {
            H3(attrs = Modifier.margin(bottom = 0.px).toAttrs()) {
                Text(name)
            }
            H5(attrs = Modifier.margin(top = 0.px).toAttrs()) {
                Text(description)
            }
            Row(
                modifier = Modifier.fillMaxSize().margin(top = 16.px),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Row {
                    for (techStack in techStacks) {
                        DevIcon(icon = techStack.icon, modifier = Modifier.color(Colors.White).margin(right = 8.px))
                        TextTooltip(text = techStack.name)
                    }
                }
                Spacer()
                Row {
                    for (url in urls) {
                        Link(
                            path = url.url,
                            modifier = Modifier.color(Colors.White).margin(left = 8.px)
                        ) {
                            getFaIcon(url.icon)
                        }
                        TextTooltip(text = url.urlName)
                    }
                }
            }
        }
    }
}