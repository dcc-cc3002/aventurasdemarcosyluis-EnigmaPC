module com.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aventurasdemarcoyluis to javafx.fxml;
    exports com.aventurasdemarcoyluis;
}