module application.ija {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.ija to javafx.fxml;
    exports application.ija;
}