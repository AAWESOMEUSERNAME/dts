package com.gugu.dts.playlist.api.`object`

interface IRule {
    val filters: List<IFilter>
    val repeatable: Boolean
    val totalNeeded: Int
    fun generatePlayList(library: IMusicLibrary): IPlayList
}