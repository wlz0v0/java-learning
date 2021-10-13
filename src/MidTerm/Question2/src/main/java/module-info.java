module edu.buptsse.question2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.buptsse.question2 to javafx.fxml;
    exports edu.buptsse.question2;
}