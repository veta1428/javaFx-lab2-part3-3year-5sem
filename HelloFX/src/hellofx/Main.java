package hellofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //
        ObservableList<String> foodTypeOptions = FXCollections.observableArrayList(
                "",
                "Not Included",
                "Breakfast Only",
                "Breakfast And Launch Only",
                "All Included");

        ComboBox foodTypeCombobox = new ComboBox(foodTypeOptions);

        ObservableList<String> tripTypeOptions = FXCollections.observableArrayList(
                "",
                "Rest",
                "Excursion",
                "Treatment",
                "Shopping",
                "Cruise");

        ComboBox tripTypeCombobox = new ComboBox(tripTypeOptions);

        ObservableList<String> transportTypeOptions = FXCollections.observableArrayList(
                "",
                "Car",
                "Train",
                "Bus",
                "Plain");

        ComboBox transportTypeCombobox = new ComboBox(transportTypeOptions);

        ObservableList<String> nightTypeOptions = FXCollections.observableArrayList(
                "",
                "7",
                "10",
                "14",
                "21");

        ComboBox nightTypeCombobox = new ComboBox(nightTypeOptions);

        ToggleGroup sortingToggleGroup = new ToggleGroup();
        
        // create radiobuttons
        RadioButton sortByPrice = new RadioButton("Price");
        RadioButton sortByNights = new RadioButton("Nights");
  
        // add radiobuttons to toggle group
        sortByPrice.setToggleGroup(sortingToggleGroup);
        sortByNights.setToggleGroup(sortingToggleGroup);


        Text greetingText = new Text("Welcome! You can find best trip for you!");
        greetingText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(greetingText, 0, 0, 2, 1);

        
        //Text scenetitle = new Text("Welcome");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        //grid.add(scenetitle, 0, 0);

        Label chooseTripTypeLabel = new Label("Select trip type:");
        grid.add(chooseTripTypeLabel, 0, 1);

        grid.add(tripTypeCombobox, 1, 1);

        Label chooseFoodTypeLabel = new Label("Select food type:");
        grid.add(chooseFoodTypeLabel, 0, 2);

        grid.add(foodTypeCombobox, 1, 2);

        Label chooseTransportTypeLabel = new Label("Select transport type:");
        grid.add(chooseTransportTypeLabel, 0, 3);

        grid.add(transportTypeCombobox, 1, 3);

        Label chooseNightsTypeLabel = new Label("Select nights:");
        grid.add(chooseNightsTypeLabel, 0, 4);

        grid.add(nightTypeCombobox, 1, 4);

        Label chooseSortingTypeLabel = new Label("Select sorting type:");
        grid.add(chooseSortingTypeLabel, 0, 5);

        grid.add(sortByNights, 1, 5);
        grid.add(sortByPrice, 1, 6);

        Button searchButton = new Button("Search");
        
        grid.add(searchButton, 0, 7);

        grid.getColumnConstraints().addAll(new ColumnConstraints( 150 ), new ColumnConstraints( 150 ), new ColumnConstraints( 150 ));

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                String tripTypeSelected = (String)tripTypeCombobox.getSelectionModel().getSelectedItem();
                String foodTypeSelected = (String)foodTypeCombobox.getSelectionModel().getSelectedItem();
                String transportSelected = (String)transportTypeCombobox.getSelectionModel().getSelectedItem();
                String nightsSelected = (String)nightTypeCombobox.getSelectionModel().getSelectedItem();
                Boolean priceSort = sortByPrice.selectedProperty().getValue();
                Boolean nightsSort = sortByNights.selectedProperty().getValue();

                System.out.println(tripTypeSelected);
                System.out.println(foodTypeSelected);
                System.out.println(transportSelected);
                System.out.println(nightsSelected);
                System.out.println(priceSort);
                System.out.println(nightsSort);
                int k = 9;
                for(int i = 0; i < 10; i++){

                    Label lbl = new Label("test1");
                    grid.add(lbl, 0, k);

                    Label lbl2 = new Label("test2");
                    grid.add(lbl2, 1, k);

                    Label lbl3 = new Label("test3");
                    grid.add(lbl3, 2, k);
                    k++;
                }
                //grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 9);
            }
        });
        //Label userName = new Label("User Name:");
        //grid.add(userName, 0, 1);

        //TextField userTextField = new TextField();
        //grid.add(userTextField, 1, 1);

        //TextField userTextField2 = new TextField();
        //grid.add(userTextField2, 2, 1);

        //Label pw = new Label("Password:");
        //grid.add(pw, 0, 2);

        //PasswordField pwBox = new PasswordField();
        //grid.add(pwBox, 1, 2);


        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}