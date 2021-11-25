package baseline;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ScrollEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.activation.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddItemController {

    @FXML
    private Label AddItemsLabel;

    @FXML
    private Label ModifyItemsLabel;



    //For AddItem.fxml
    @FXML
    private TextField enterSerialNumberItemsTextBox;

    @FXML
    private TextField enterNameItemsTextBox;

    @FXML
    private TextField enterInventoryItemsTextBox;

    @FXML
    private TextField enterPriceItemsTextBox;

    @FXML
    private Button saveItemsAP;

    @FXML
    private Button saveItemsMP;

    @FXML
    private Button cancelItems;

    //initializing for Inventory.
    @FXML
    public void initialize() {

        if (Inventory.selectedItem != null) {
            enterSerialNumberItemsTextBox.setText(Inventory.selectedItem.getItemSerialNumber() + "");
            enterNameItemsTextBox.setText(Inventory.selectedItem.getItemName() + "");
            enterInventoryItemsTextBox.setText(Inventory.selectedItem.getItemInventory() + "");
            enterPriceItemsTextBox.setText(Inventory.selectedItem.getItemPrice() + "");
        }
    }
    //Cancel Item into new screen.
    @FXML
    void cancelParts(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = (Stage) enterNameItemsTextBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Save Items
    @FXML
    void saveItemsAP(ActionEvent event) throws IOException
    {

        Integer itemsSerialNumber = 0;
        String nameItems = "";
        String InventoryItems = "";
        Integer inventoryItems = 0;
        String PriceItems = "";
        Double priceItems = 0.0;

        /*
         Data Checks for:
                Serial Number doesnt fill.
                Items greater than array size
                radio button selection
                inventory
                empty text boxes
                checks for numbers in text boxes where required
         */

         if (AddItem.isSelected() == true) {

            try{
                AddItemsLabel.setText("Serial Number");
                itemSerialNumber = Inventory.itemArray.size();
                nameItems = enterNameItemsTextBox.getText();
                Inventoryitems = enterInventoryItemsTextBox.getText();
                inventoryItems = Integer.parseInt(Inventoryitems);
                Priceitems = enterPriceCostItemsTextBox.getText();
                priceItems = Double.parseDouble(Priceitems);

            }
            catch (NumberFormatException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Correct the numeric data into the areas.");
                alert.setHeaderText("Correct the numeric data into the areas.");
                alert.setContentText("Correct the numeric data into the areas.");
                alert.showAndWait();
            }

            if (nameItems == null || InventoryItems == null || PriceItems == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Please enter missing data");
                alert.setHeaderText("Please enter missing data");
                alert.setContentText("Please enter missing data");
                alert.showAndWait();
            }

            if (inventoryItems > 1024 || inventoryItems < 0 || 0 > 1024) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Enter between 1 to 1024");
                alert.setHeaderText("Enter between 1 to 1024");
                alert.setContentText("Enter between 1 to 1024");
                alert.showAndWait();
            }
            else
            {
                Inventory.itemArray.add(new Inventory(itemsSerialNumber, nameItems, inventoryItems, priceItems));
            }
        }
         //Load MainScreen.
        Stage stage;
        Parent root;
        stage = (Stage) enterSerialNumberItemsTextBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveItemsMP(ActionEvent event) throws IOException {

        Integer itemSerialNumber = 0;
        String nameItems = "";
        String Inventoryitems = "";
        Integer inventoryItems = 0;
        String Priceitems = "";
        Double priceItems = 0.0;

        /*
        Data Checks for:
                Serial Number doesnt fill.
                Items greater than array size
                radio button selection
                inventory
                empty text boxes
                checks for numbers in text boxes where required
         */
         if (ModifyItem.isSelected() == true) {

            AddItemsLabel.setText("Serial Number");
            String SerialNumberItems = enterSerialNumberItemsTextBox.getText();
            itemSerialNumber = Integer.parseInt(SerialNumberItems);

            if (itemSerialNumber < 1 || itemSerialNumber > Inventory.itemArray.size()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Enter a letter then a mix of letters and numbers.");
                alert.setHeaderText("Enter a letter then a mix of letters and numbers.");
                alert.setContentText("Enter a letter then a mix of letters and numbers.");
                alert.showAndWait();
            } else {

                try{
                    nameItems = enterNameItemsTextBox.getText();
                    Inventoryitems = enterInventoryItemsTextBox.getText();
                    inventoryItems = Integer.parseInt(Inventoryitems);
                    Priceitems = enterPriceCostItemsTextBox.getText();
                    priceItems = Double.parseDouble(Priceitems);

                }catch (NumberFormatException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Please enter missing data");
                    alert.setHeaderText("Please enter missing data");
                    alert.setContentText("Please enter missing data");
                    alert.showAndWait();
                }

                if (nameItems == null || Inventoryitems == null || Priceitems == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Please enter the missing info");
                    alert.setHeaderText("Please enter the missing info");
                    alert.setContentText("Please enter the missing info");
                    alert.showAndWait();
                }

                if (inventoryItems > 1024 || inventoryItems < 0 || 0 > 1024) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Enter between 1 to 1024");
                    alert.setHeaderText("Enter between 1 to 1024");
                    alert.setContentText("Enter between 1 to 1024");
                    alert.showAndWait();
                } else {
                    for (int i = 0; i < Inventory.itemArray.size(); i++) {
                        if (Inventory.itemArray.get(i).getPartID() == itemSerialNumber) {
                            Inventory.itemArray.remove(i);
                            break;
                        }
                    }
                    Inventory.itemArray.add(new ModifyItem(itemSerialNumber, nameItems, inventoryItems, priceItems));
                }
            }
        }
         //load MainScreen.
        Inventory.selectedItem = null;
        Stage stage;
        Parent root;
        stage = (Stage) enterSerialNumberItemsTextBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
