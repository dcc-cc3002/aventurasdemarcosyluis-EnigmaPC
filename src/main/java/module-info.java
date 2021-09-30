module com.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.aventurasdemarcoyluis.abstract_classes;
    opens com.aventurasdemarcoyluis.abstract_classes to javafx.fxml;
    exports com.aventurasdemarcoyluis.interfaces;
    opens com.aventurasdemarcoyluis.interfaces to javafx.fxml;
    exports com.aventurasdemarcoyluis.enemies;
    opens com.aventurasdemarcoyluis.enemies to javafx.fxml;
    exports com.aventurasdemarcoyluis.players;
    opens com.aventurasdemarcoyluis.players to javafx.fxml;
    exports com.aventurasdemarcoyluis.items;
    opens com.aventurasdemarcoyluis.items to javafx.fxml;
    exports com.aventurasdemarcoyluis.attacks;
    opens com.aventurasdemarcoyluis.attacks to javafx.fxml;
}