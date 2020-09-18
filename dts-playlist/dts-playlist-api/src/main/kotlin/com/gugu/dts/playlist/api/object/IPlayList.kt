package com.gugu.dts.playlist.api.`object`

import java.io.File

interface IPlayList {
    val songs: MutableList<ISong>
    fun add(song: ISong)
    fun toFile(): File
}