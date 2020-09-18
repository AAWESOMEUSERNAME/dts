package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.ISong

class Song(
        override val name: String,
        override val path: String,
        override val playedTimes: Int = 0,
        override val bpm: Double = 0.0
) : ISong