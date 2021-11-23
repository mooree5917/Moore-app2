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

public abstract class Item { //make abstract

    // partID, partName, partInventory, partPrice, partMax, partMin
    private IntegerProperty partSerialNumber;
    private StringProperty partName;
    private DoubleProperty partPrice;


    public Item(int partID, String partName, Double partPrice) {
        this.partSerialNumber = new SimpleIntegerProperty(partID);
        this.partName = new SimpleStringProperty(partName);
        this.partPrice = new SimpleDoubleProperty(partPrice);
    }

    public IntegerProperty partIDProperty() {
        return partSerialNumber;
    }

    public StringProperty partNameProperty() {
        return partName;
    }


    public DoubleProperty partPriceProperty() {
        return partPrice;
    }


    //------------------------------------------------------------------------------
    public void setPartID(int partID) {
        this.partSerialNumber = new SimpleIntegerProperty(partID);
    }

    public int getPartID() {
        return partSerialNumber.get();
    }

    public void setPartName(String PartName) {
        this.partName.set(PartName);
    }

    public String getPartName() {
        return partName.get();
    }

    public void setPartPrice(Double PartPrice) {
        this.partPrice.set(PartPrice);
    }

    public Double getPartPrice() {
        return partPrice.get();
    }
}
