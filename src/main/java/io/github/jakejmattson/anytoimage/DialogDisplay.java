package io.github.jakejmattson.anytoimage;

import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;

public class DialogDisplay
{
	public static void displayInfo(String title, String message)
	{
		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle(title);
		dialog.setHeaderText(null);
		dialog.setContentText(message);
		dialog.showAndWait();
	}

	public static void displayError(String title, String message)
	{
		Alert dialog = new Alert(Alert.AlertType.ERROR);
		dialog.setTitle(title);
		dialog.setHeaderText(null);
		dialog.setContentText(message);
		dialog.showAndWait();
	}

	public static void displayException(Exception e, String message)
	{
		System.out.println(message);
		e.printStackTrace();

		//Create dialog
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Something went wrong!");
		alert.setHeaderText(null);
		alert.setContentText(message);

		//Get exception as string
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionText = sw.toString();

		//Create a text area to display the exception
		TextArea textArea = new TextArea(exceptionText);
		textArea.setStyle("-fx-text-inner-color: red;");
		textArea.setEditable(false);

		//Format content
		GridPane expContent = new GridPane();
		expContent.add(new Label("Exception stacktrace:"), 0, 0);
		expContent.add(textArea, 0, 1);

		//Display exception
		alert.getDialogPane().setExpandableContent(expContent);
		alert.showAndWait();
	}
}