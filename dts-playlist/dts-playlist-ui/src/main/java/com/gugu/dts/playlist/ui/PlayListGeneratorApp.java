package com.gugu.dts.playlist.ui;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenyiyang
 * @date 2020/9/28
 */
@SpringBootApplication
public class PlayListGeneratorApp extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(PlayListGeneratorApp.class,MainView.class,args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("播放列表生成器");
        stage.setResizable(false);
        super.start(stage);
    }
}
