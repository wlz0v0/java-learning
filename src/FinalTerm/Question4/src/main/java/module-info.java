module edu.question4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.question4 to javafx.fxml;
    exports edu.question4;
}