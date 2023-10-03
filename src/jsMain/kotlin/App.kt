import js.core.jso
import mui.material.CssBaseline
import mui.material.PaletteMode.Companion.dark
import mui.material.styles.ThemeProvider
import mui.material.styles.createTheme
import react.FC
import react.create
import react.dom.client.createRoot
import web.dom.document

val darkTheme = createTheme(jso {
    palette = jso { mode = dark }
})

val App = FC {
    ThemeProvider {
        theme = darkTheme
        CssBaseline()

        +Home.create()
    }
}

fun main() {
    createRoot(document.body)
        .render(App.create())
}