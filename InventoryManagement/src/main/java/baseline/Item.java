package baseline;

import java.lang.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Item
{

    // itemSerialNumber, itemName, itemPrice
    private IntegerProperty itemSerialNumber;
    private StringProperty itemName;
    private DoubleProperty itemPrice;


    public Item(int itemSerialNumber, String itemName, Double itemPrice) {
        this.itemSerialNumber = new SimpleIntegerProperty(itemSerialNumber);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemPrice = new SimpleDoubleProperty(itemPrice);
    }
    //Properties
    public IntegerProperty itemSerialNumberProperty()
    {
        return itemSerialNumber;
    }

    public StringProperty itemNameProperty()
    {
        return itemName;
    }


    public DoubleProperty itemPriceProperty()
    {
        return itemPrice;
    }


    //Grab Serial Number
    public void setItemSerialNumber(int itemSerialNumber)
    {
        this.itemSerialNumber = new SimpleIntegerProperty(itemSerialNumber);
    }

    public int getItemSerialNumber()
    {
        return itemSerialNumber.get();
    }
    //Grab Name
    public void setItemName(String ItemName)
    {
        this.itemName.set(ItemName);
    }

    public String getItemName()
    {
        return itemName.get();
    }
    //Grab price.
    public void setPartPrice(Double ItemPrice)
    {
        this.itemPrice.set(ItemPrice);
    }

    public Double getItemPrice()
    {
        return itemPrice.get();
    }
}
