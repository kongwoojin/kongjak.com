import dto.ProjectUrl
import dto.TechStack
import emotion.react.css
import mui.material.*
import mui.material.Size
import mui.material.styles.TypographyVariant
import mui.system.responsive
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.create
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import string.TITLE
import utils.openLink
import web.cssom.*
import web.cssom.Auto.Companion.auto

external interface ProjectProps : Props {
    var name: String
    var description: String
    var urls: List<ProjectUrl>
    var techStack: List<TechStack>?
}

val Home = FC {
    Container {
        +Main.create()

        Stack {
            sx {
                flexWrap = FlexWrap.wrap
                justifyContent = JustifyContent.center
            }
            direction = responsive(StackDirection.row)
            spacing = responsive(3)
            useFlexGap = true

            for (project in projectList) {
                +Project.create {
                    name = project.name
                    description = project.description
                    urls = project.urls
                    techStack = project.techStack
                }
            }
        }

        +Footer.create()
    }
}

private val Main = FC {
    div {
        css {
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = AlignItems.center
            height = 100.vh
        }

        Grid {
            Box {
                Typography {
                    sx {
                        textAlign = TextAlign.center
                    }
                    variant = TypographyVariant.h5
                    +TITLE
                }
            }
            Box {
                for (contact in linkLists) {
                    Tooltip {
                        title = ReactNode(contact.name)
                        IconButton {
                            color = IconButtonColor.inherit
                            onClick = {
                                openLink(contact.url)
                            }
                            contact.icon()
                        }
                    }
                }
            }
        }
    }
}

private val Project = FC<ProjectProps> { props ->
    Box {
        sx {
            display = Display.flex
            scrollSnapMargin = 8.px
        }

        Card {
            sx {
                minWidth = 250.px
                maxWidth = 250.px
                display = Display.flex
                flexDirection = FlexDirection.column
            }
            CardContent {
                sx {
                    marginBottom = auto
                }
                Typography {
                    component = div
                    variant = TypographyVariant.h5
                    +props.name
                }
                Typography {
                    component = div
                    variant = TypographyVariant.body2
                    +props.description
                }
            }
            CardActions {
                sx {
                    marginTop = auto
                    display = Display.flex
                }
                if (props.techStack != null) {
                    for (techStack in props.techStack!!) {
                        Tooltip {
                            title = ReactNode(techStack.name)
                            ReactHTML.i {
                                className = ClassName(techStack.icon)
                            }
                        }
                    }
                }

                for (url in props.urls) {
                    if (url.icon != null) {
                        Tooltip {
                            title = ReactNode(url.urlName)
                            IconButton {
                                sx {
                                    marginLeft = auto
                                }
                                color = IconButtonColor.inherit
                                onClick = {
                                    openLink(url.url)
                                }
                                url.icon!!()
                            }
                        }
                    } else {
                        Button {
                            sx {
                                marginLeft = auto
                            }
                            size = Size.small
                            href = url.url
                            +url.urlName
                        }
                    }
                }
            }
        }
    }
}