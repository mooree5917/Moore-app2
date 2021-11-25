package baseline;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.activation.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DocumentController {
    private int selectedItem;

    @FXML
    public void initialize() {

// Part Cell data
        itemSerialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().itemSerialNumberProperty().asObject());
        itemNameColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        itemInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().itemInventoryProperty().asObject());
        itemPriceColumn.setCellValueFactory(cellData -> cellData.getValue().itemPriceProperty().asObject());

//------------------------------------------------------------------------------
// Table for Items
        itemsTableView.setItems(Inventory.itemArray);

        Inventory.selectedItem = null;
    }

    @FXML
    private Label label;

    @FXML
    void exitButton(ActionEvent event)
    {
        System.exit(0);
    }

    //Table grid.
    @FXML
    private TableView<Item> itemTableView;

    @FXML
    private TableColumn<Item, Integer> partSerialNumberColumn;

    @FXML
    private TableColumn<Item, String> itemNameColumn;

    @FXML
    private TableColumn<Item, Integer> itemInventoryColumn;

    @FXML
    private TableColumn<Item, Double> itemPriceColumn;

    @FXML
    TextField searchItemsTextBox;

    //Search for Items.

    @FXML
    void searchItems(ActionEvent event) {

        String searchText = searchItemsTextBox.getText();
        FilteredList<Item> searchPartResults = searchParts(searchText);
        SortedList<Item> sortedPartData = new SortedList<>(searchPartResults);
        sortedPartData.comparatorProperty().bind(itemsTableView.comparatorProperty());
        itemsTableView.setItems(sortedPartData);
    }

    public FilteredList<Item> searchParts(String s) {
        return Inventory.getItemData().filtered(p -> p.getItemName().toLowerCase().contains(s.toLowerCase()));
    }

    //Deleting Items
    @FXML

    void deleteItems(ActionEvent event) {

        Item selectedPart = itemsTableView.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {

            //Confirm Delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete?");
            alert.setHeaderText("Deleting Item.");
            alert.setContentText("Are you sure you would like to  Delete " + selectedPart.getItemSerialNumber() + "?");
            alert.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> Inventory.getItemData().remove(selectedItem));

            //update items table
            itemsTableView.setItems(Inventory.getItemData());
        } else {

            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No item was selected.");
            alert.setContentText("Please select an item from the inventory.");
            alert.showAndWait();
        }
    }

    //Add Items into AddItemScreen.
    @FXML
    void addItems(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = (Stage) searchItemsTextBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AddItemScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //Modify items into ModifyItemScreen.
    @FXML
    void modifyItems(ActionEvent event) throws IOException {
        // Serial Number, Name, Inventory, Price

        Inventory.selectedItem = itemsTableView.getSelectionModel().getSelectedItem();

        Stage stage;
        Parent root;
        stage = (Stage) searchItemsTextBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ModifyItemScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
