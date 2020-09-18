package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.IFilter
import com.gugu.dts.playlist.api.`object`.IMusicLibrary
import com.gugu.dts.playlist.api.`object`.IPlayList
import com.gugu.dts.playlist.api.`object`.IRule

class Rule(
        override val filters: List<IFilter>,
        override val repeatable: Boolean,
        override val totalNeeded: Int
) : IRule {
    override fun generatePlayList(library: IMusicLibrary): IPlayList {
        TODO("Not yet implemented")
    }
}