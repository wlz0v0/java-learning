module edu.buptsse.unit04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.buptsse.unit04 to javafx.fxml;
    exports edu.buptsse.unit04;
}