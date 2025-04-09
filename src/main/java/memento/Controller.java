package memento;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoList; // Memento undoList (Undo stack)
    private List<IMemento> redoList; // Redo stack

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoList.clear();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoList.clear();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("Memento found in undoList");
            IMemento currentState = model.createMemento();
            redoList.add(currentState);

            IMemento previousState = undoList.remove(undoList.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (redoList != null && !redoList.isEmpty()) {
            System.out.println("Memento found in undoList");
            IMemento currentState = model.createMemento();
            undoList.add(currentState);

            IMemento redoState = redoList.remove(redoList.size() - 1);
            model.restoreState(redoState);
            gui.updateGui();
        } else {
            System.out.println("Nothing to redo");
        }
    }


    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        undoList.add(currentState);
    }

    public void showHistoryWindow() {
        ObservableList<IMemento> observableHistory = FXCollections.observableArrayList(undoList);

        ListView<IMemento> listView = new ListView<>(observableHistory);

        listView.setOnMouseClicked(event -> {
            IMemento selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                model.restoreState(selected);
                gui.updateGui();
            }
        });

        VBox layout = new VBox(listView);
        Scene scene = new Scene(layout, 300, 300);
        Stage historyStage = new Stage();
        historyStage.setTitle("History");
        historyStage.setScene(scene);
        historyStage.show();
    }
}

