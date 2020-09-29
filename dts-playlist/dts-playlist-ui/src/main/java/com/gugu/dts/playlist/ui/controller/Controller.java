package com.gugu.dts.playlist.ui.controller;

import com.gugu.dts.playlist.ui.dto.FilterRowDTO;
import com.gugu.dts.playlist.ui.dto.LibRowDTO;
import com.gugu.dts.playlist.ui.usecase.MusicLibUsecase;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport.getStage;


/**
 * @author chenyiyang
 * @date 2020/9/28
 */
@FXMLController
public class Controller implements Initializable {

    private Stage rootStage;
    private MusicLibUsecase musicLibUsecase;
    @FXML
    private TextField in_totalNum;
    @FXML
    private Label lab_currentLib;
    private long currentLibId;
    @FXML
    private Button btn_generate;
    @FXML
    private Button btn_import;
    @FXML
    private Button btn_addFilter;
    @FXML
    private TableView<LibRowDTO> table_musicLib;
    @FXML
    private TableColumn<LibRowDTO, Long> col_musicLib_id;
    @FXML
    private TableColumn<LibRowDTO, Date> col_musicLib_importTime;
    @FXML
    private TableColumn<LibRowDTO, String> col_musicLib_path;
    @FXML
    private TableColumn<LibRowDTO, String> col_musicLib_libName;
    @FXML
    private TableView<FilterRowDTO> table_filter;
    @FXML
    private TableColumn<FilterRowDTO, Double> col_filter_bpmMin;
    @FXML
    private TableColumn<FilterRowDTO, Double> col_filter_bpmMax;
    @FXML
    private TableColumn<FilterRowDTO, Integer> col_filter_songNum;
    public Controller(MusicLibUsecase musicLibUsecase) {
        this.musicLibUsecase = musicLibUsecase;
    }

    @FXML
    void generatePlaylist(MouseEvent event) {

    }

    @FXML
    void addFilter(MouseEvent event) {
        table_filter.getItems().add(FilterRowDTO.EMPTY_ROW);
    }

    @FXML
    void importLib(MouseEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(rootStage);
        musicLibUsecase.importLib(selectedDirectory);
        initTableData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootStage = getStage();
        initCellValueFactory();
        initTableData();
        initTableListener();
        makeTableEditable();
    }

    private void initTableListener() {
        table_musicLib.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lab_currentLib.setText(newValue.getName());
            currentLibId = newValue.getId();
        });
    }

    private void initTableData() {
        List<LibRowDTO> rows = musicLibUsecase.load();
        table_musicLib.setItems(FXCollections.observableList(rows));
    }

    private void makeTableEditable() {
        table_filter.getSelectionModel().cellSelectionEnabledProperty().set(true);
        col_filter_bpmMin.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleToStringConverter()));
        col_filter_bpmMin.setOnEditCommit(event -> {
            (event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setBpmMin(event.getNewValue());
        });
        col_filter_bpmMax.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleToStringConverter()));
        col_filter_bpmMax.setOnEditCommit(event -> {
            (event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setBpmMax(event.getNewValue());
        });
        col_filter_songNum.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerToStringConverter()));
        col_filter_songNum.setOnEditCommit(event -> {
            (event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setSongNum(event.getNewValue());
        });
    }

    private void initCellValueFactory() {
        col_filter_bpmMin.setCellValueFactory(new PropertyValueFactory<>(FilterRowDTO.PROP_MIN));
        col_filter_bpmMax.setCellValueFactory(new PropertyValueFactory<>(FilterRowDTO.PROP_MAX));
        col_filter_songNum.setCellValueFactory(new PropertyValueFactory<>(FilterRowDTO.PROP_NUM));

        col_musicLib_id.setCellValueFactory(new PropertyValueFactory<>(LibRowDTO.PROP_ID));
        col_musicLib_libName.setCellValueFactory(new PropertyValueFactory<>(LibRowDTO.PROP_NAME));
        col_musicLib_importTime.setCellValueFactory(new PropertyValueFactory<>(LibRowDTO.PROP_IMPORT_TIME));
        col_musicLib_path.setCellValueFactory(new PropertyValueFactory<>(LibRowDTO.PROP_PATH));
    }

}

class DoubleToStringConverter extends StringConverter<Double> {
    @Override
    public String toString(Double object) {
        return object.toString();
    }

    @Override
    public Double fromString(String string) {
        return Double.parseDouble(string);
    }
}

class IntegerToStringConverter extends StringConverter<Integer> {
    @Override
    public String toString(Integer object) {
        return object.toString();
    }

    @Override
    public Integer fromString(String string) {
        return Integer.parseInt(string);
    }
}
