package repository

import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO
import com.gugu.dts.playlist.core.entity.MusicLibrary
import com.gugu.dts.playlist.core.entity.Song
import com.gugu.dts.playlist.core.repository.MusicLibraryRepository
import com.gugu.dts.playlist.inf.mapper.MusicLibraryMapper
import com.gugu.dts.playlist.inf.mapper.SongMapper

class MusicLibraryRepositoryImpl(
        private val libraryMapper: MusicLibraryMapper,
        private val songMapper: SongMapper
) : MusicLibraryRepository {

    override fun import(library: IMusicLibraryDTO): MusicLibrary {
        val entity = toEntity(library)
        libraryMapper.insertSelective(entity)
        return toModule(entity)!!
    }

    override fun fetchLibraryByName(name: String): MusicLibrary? {
        return toModule(libraryMapper.selectByName(name))
    }

    override fun list(): List<MusicLibrary> {
        return libraryMapper.list().map { toModule(it)!! }
    }

    private fun toModule(entity: com.gugu.dts.playlist.inf.entity.MusicLibrary?): MusicLibrary? {
        if (entity == null) {
            return null
        }

        val songs = songMapper.selectByLibraryId(entity.id).map { toModule(it!!) }.toList()
        return MusicLibrary(
                entity.name,
                entity.path,
                songs,
                entity.id
        )
    }

    private fun toModule(entity: com.gugu.dts.playlist.inf.entity.Song): Song {
        return Song(
                id = entity.id,
                name = entity.name,
                path = entity.path,
                bpm = entity.bpm
        )
    }

    private fun toEntity(dto: IMusicLibraryDTO): com.gugu.dts.playlist.inf.entity.MusicLibrary {
        val entity = com.gugu.dts.playlist.inf.entity.MusicLibrary()
        entity.name = dto.name
        entity.path = dto.path
        return entity
    }
}
