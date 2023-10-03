import emotion.react.css
import mui.material.*
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.ReactNode
import react.dom.html.ReactHTML
import string.TITLE
import utils.openLink
import web.cssom.AlignSelf
import web.cssom.Display
import web.cssom.number
import web.cssom.px

val Footer = FC {
    ReactHTML.footer {
        css {
            marginTop = 64.px
            marginBottom = 32.px
            display = Display.flex

        }
        Typography {
            sx {
                flexGrow = number(1.0)
            }
            variant = TypographyVariant.body2
            +"Copyright © 2023 $TITLE. All rights reserved."
        }
        Box {
            sx {
                alignSelf = AlignSelf.flexEnd
            }
            for (contact in linkLists) {
                Tooltip {
                    placement = TooltipPlacement.top
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