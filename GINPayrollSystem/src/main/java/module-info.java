module com.mycompany.ginpayrollsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.ginpayrollsystem to javafx.fxml;
    opens Controller to javafx.fxml;
    exports com.mycompany.ginpayrollsystem;
}
