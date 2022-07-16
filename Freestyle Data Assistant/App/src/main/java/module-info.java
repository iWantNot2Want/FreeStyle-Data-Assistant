module com.example.freestyledataassistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.freestyledataassistant to javafx.fxml;
    exports com.example.freestyledataassistant;
}