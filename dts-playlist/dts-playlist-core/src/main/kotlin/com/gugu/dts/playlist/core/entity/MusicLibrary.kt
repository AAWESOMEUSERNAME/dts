package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.IMusicLibrary
import com.gugu.dts.playlist.api.`object`.ISong

class MusicLibrary(
        override val name: String,
        override val songs: List<ISong>
) : IMusicLibrary {
    override fun resetAllPlayedTimes() {
        TODO("Not yet implemented")
    }
}