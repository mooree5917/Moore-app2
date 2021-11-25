package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    public static Item selectedItem;

    public void addItem(int itemSerialNumber, String itemName, int itemInventory, Double itemPrice)
    {
        Item newItem = new Inventory(itemSerialNumber, itemName, itemInventory, itemPrice);
        Inventory.itemArray.add(newItem);
    }


     //Serial Number, Name, Inventory, Price

    public static ObservableList<Item> ItemArray = FXCollections.observableArrayList();

    public static ObservableList<Item> getItemData()
    {
        return ItemArray;
    }
}
