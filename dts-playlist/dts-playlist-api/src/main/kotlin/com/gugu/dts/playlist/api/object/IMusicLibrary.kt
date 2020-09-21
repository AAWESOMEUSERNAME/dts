package com.gugu.dts.playlist.api.`object`

interface IMusicLibrary {
    val name: String
    val path: String
    val songs: List<ISong>
}