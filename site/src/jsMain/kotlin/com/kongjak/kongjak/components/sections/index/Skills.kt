package com.kongjak.kongjak.components.sections.index

import androidx.compose.runtime.Composable
import com.kongjak.kongjak.components.widgets.TextTooltip
import com.kongjak.kongjak.models.Skill
import com.kongjak.kongjak.utils.languages
import com.kongjak.kongjak.utils.platformsAndFrameworks
import com.kongjak.kongjak.utils.tools
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun IndexSkills() {
    SimpleGrid(
        modifier = Modifier.minWidth(100.percent).minHeight(100.vh).id("skills"),
        numColumns = numColumns(1, md = 2, lg = 3),
    ) {
        SkillWidget(
            "Languages",
            languages
        )

        SkillWidget(
            "Platform & Frameworks",
            platformsAndFrameworks
        )

        SkillWidget(
            "Tools",
            tools
        )
    }
}

@Composable
fun SkillWidget(
    title: String,
    skills: List<Skill>
) {
    Column(
        modifier = Modifier.fillMaxWidth().margin(topBottom = 16.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H2 {
            Text(title)
        }

        SimpleGrid(
            modifier = Modifier.minHeight(160.px),
            numColumns = numColumns(1, md = 2, lg = 3),
        ) {
            for (skill in skills) {
                Image(
                    modifier = Modifier.margin(16.px),
                    src = skill.iconPath,
                    alt = skill.name,
                    height = 48
                )
                TextTooltip(text = skill.name)
            }
        }
    }
}