package com.kongjak.kongjak.pages

import androidx.compose.runtime.Composable
import com.kongjak.kongjak.components.layouts.PageLayout
import com.kongjak.kongjak.components.sections.index.IndexMain
import com.kongjak.kongjak.components.sections.index.IndexProjects
import com.kongjak.kongjak.components.sections.index.IndexSkills
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        IndexMain()
        IndexSkills()
        IndexProjects()
    }
}
