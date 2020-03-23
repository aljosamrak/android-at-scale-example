import Utils.envOrProperty

plugins {
    id(Orchid.plugin) version Orchid.version
}

dependencies {
    orchidImplementation(Orchid.core)
    orchidRuntimeOnly(Orchid.posts)
    orchidRuntimeOnly(Orchid.pages)
    orchidRuntimeOnly(Orchid.wiki)
    orchidRuntimeOnly(Orchid.docs)
    orchidRuntimeOnly(Orchid.pluginDocs)
    orchidRuntimeOnly(Orchid.kotlinDoc)
    orchidRuntimeOnly(Orchid.search)
    orchidRuntimeOnly(Orchid.writerBlocks)
    orchidRuntimeOnly(Orchid.syntaxHighlighter)
    orchidRuntimeOnly(Orchid.diagrams)
    orchidRuntimeOnly(Orchid.editorialTheme)
    orchidRuntimeOnly(Orchid.github)
    orchidRuntimeOnly(Orchid.changelog)
}

orchid {
    val isProd = envOrProperty("env") == "prod"
    version = "${project.version}"
    theme = "Editorial"
    environment = if (isProd) "production" else "debug"
    baseUrl = when {                                        // a baseUrl prepended to all generated links. Defaults to '/'
        isProd && envOrProperty("PULL_REQUEST") == "true" -> envOrProperty("orchidUrl", required = true)
        isProd ->  envOrProperty("orchidUrl", required = true)
        else -> "http://localhost:8080"
    }

    githubToken = envOrProperty("githubToken", required = true)
}