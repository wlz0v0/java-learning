module edu.buptsse.project3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.buptsse.project3 to javafx.fxml;
    exports edu.buptsse.project3;
}