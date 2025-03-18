module org.example.opsa18 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.opsa18 to javafx.fxml;
    exports org.example.opsa18;
}