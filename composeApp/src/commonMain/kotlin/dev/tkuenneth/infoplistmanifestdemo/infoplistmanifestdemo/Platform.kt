package dev.tkuenneth.infoplistmanifestdemo.infoplistmanifestdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform