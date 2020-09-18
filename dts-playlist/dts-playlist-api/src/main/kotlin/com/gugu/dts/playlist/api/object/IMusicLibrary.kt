package com.gugu.dts.playlist.api.`object`

interface IMusicLibrary {
    val name: String
    val songs: List<ISong>

    fun resetAllPlayedTimes()
}