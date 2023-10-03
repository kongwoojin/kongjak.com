import dto.Link
import dto.Project
import dto.ProjectUrl
import dto.TechStack
import mui.icons.material.*
import string.GITHUB_URL
import string.MAIL_ADDRESS
import string.TELEGRAM_URL

val linkLists = listOf(
    Link("Telegram", TELEGRAM_URL, Telegram),
    Link("Github", GITHUB_URL, GitHub),
    Link("Mail", "mailto:$MAIL_ADDRESS", Mail)
)

val projectList = listOf(
    Project(
        "Koreatech Board (Android)",
        "Unofficial android client for Koreatech board",
        listOf(
            ProjectUrl("#", "Android", Android),
            ProjectUrl("https://github.com/kongwoojin/koreatech-board-android", "Github", GitHub)
        ),
        listOf(
            TechStack(
                "Kotlin",
                Icons.KOTLIN
            )
        )
    ),
    Project(
        "Koreatech Board (API)",
        "Unofficial API Wrapper for Koreatech Board",
        listOf(
            ProjectUrl("https://api.kongjak.com/swagger/index.html", "API", Api),
            ProjectUrl("https://github.com/kongwoojin/koreatech-board-api", "Github", GitHub)
        ),
        listOf(
            TechStack(
                "Go",
                Icons.GO
            )
        )
    ),
    Project(
        "Koreatech Board (Crawler)",
        "Koreatech Board crawler",
        listOf(ProjectUrl("https://github.com/kongwoojin/koreatech-board-crawler", "Github", GitHub)),
        listOf(
            TechStack(
                "Python",
                Icons.PYTHON
            )
        )
    ),
    Project(
        "gobuild",
        "Cli tool for cross-compile Go",
        listOf(ProjectUrl("https://github.com/kongwoojin/gobuild", "Github", GitHub)),
        listOf(
            TechStack(
                "Go",
                Icons.GO
            )
        )
    ),
    Project(
        "LineageOS for EF65S",
        "LineageOS 16.0 and 17.1 for Pantech Vega Pop-Up Note",
        listOf(
            ProjectUrl("https://dl.kongjak.com/ef65/LineageOS/", "Download", Download),
            ProjectUrl("https://github.com/sky-vega-dev-team", "Github", GitHub)
        )
    ),
    Project(
        "Pantech Archive",
        "Archive for Pantech device Stock Firmwares & OpenSources",
        listOf(ProjectUrl("https://pantech.kongjak.com", "Download", Download))
    ),
    Project(
        "More",
        "See more project on my Github!",
        listOf(ProjectUrl("https://github.com/kongwoojin", "Github", GitHub))
    ),
)