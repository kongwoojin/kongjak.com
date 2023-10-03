package dto

import mui.icons.material.SvgIconComponent

data class Project(
    val name: String,
    val description: String,
    val urls: List<ProjectUrl>,
    val techStack: List<TechStack>? = null
)

data class ProjectUrl(
    val url: String,
    val urlName: String,
    val icon: SvgIconComponent? = null
)

data class TechStack(
    val name: String,
    val icon: String
)