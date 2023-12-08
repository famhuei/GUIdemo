package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChatWindow extends Application {

    private TextArea chatArea;
    private TextField messageField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Window");

        // Tạo các thành phần GUI
        chatArea = new TextArea();
        chatArea.setEditable(false);  // Không cho phép chỉnh sửa nội dung chat
        messageField = new TextField();
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        // Tạo layout và đặt các thành phần vào layout
        HBox messageBox = new HBox(10);
        messageBox.getChildren().addAll(messageField, sendButton);

        BorderPane layout = new BorderPane();
        layout.setCenter(chatArea);
        layout.setBottom(messageBox);
        BorderPane.setMargin(messageBox, new Insets(10));

        // Đặt layout vào scene
        Scene scene = new Scene(layout, 400, 300);

        // Đặt scene vào stage
        primaryStage.setScene(scene);

        // Hiển thị cửa sổ
        primaryStage.show();
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            messageField.clear();
        }
    }

}

