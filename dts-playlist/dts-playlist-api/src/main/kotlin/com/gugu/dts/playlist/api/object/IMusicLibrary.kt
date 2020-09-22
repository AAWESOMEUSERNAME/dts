package com.gugu.dts.playlist.api.`object`

interface IMusicLibrary {
    val id: Int?
    val name: String
    val path: String
    val songs: List<ISong>
}