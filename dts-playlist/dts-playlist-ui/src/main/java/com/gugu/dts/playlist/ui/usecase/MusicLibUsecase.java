package com.gugu.dts.playlist.ui.usecase;

import com.gugu.dts.playlist.ui.dto.LibRowDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyiyang
 * @date 2020/9/29
 */
@Component
public class MusicLibUsecase {
    public List<LibRowDTO> load() {
        // todo
        return Stream.of(
                new LibRowDTO(1, "time1","path","name1"),
                new LibRowDTO(2, "time2","path","name2"),
                new LibRowDTO(3, "time3","path","name3"),
                new LibRowDTO(4, "time4","path","name4")
        ).collect(Collectors.toList());
    }

    public void importLib(File selectedDirectory) {

    }
}
