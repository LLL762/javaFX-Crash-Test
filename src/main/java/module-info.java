module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.login to javafx.fxml;
    opens com.example.login.controller to javafx.fxml;

    exports com.example.login;
    exports com.example.login.controller;

}