package hellofx;

import java.util.ArrayList;

import builder.PredicateBuilder;
import builder.Query;
import builder.QueryBuilder;
import builder.QueryHandler;
import context.DataContext;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import types.Food;
import types.SortType;
import types.Transport;
import types.TripType;
import vouchers.Voucher;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //
        ObservableList<String> foodTypeOptions = FXCollections.observableArrayList(
                Constants.StringEmpty,
                Constants.NotIncluded,
                Constants.BreakfastOnly,
                Constants.BreakfastAndLaunchOnly,
                Constants.AllIncluded);

        ComboBox foodTypeCombobox = new ComboBox(foodTypeOptions);

        ObservableList<String> tripTypeOptions = FXCollections.observableArrayList(
                Constants.StringEmpty,
                Constants.Rest,
                Constants.Cruise,
                Constants.Treatment,
                Constants.Shopping,
                Constants.Excursion);

        ComboBox tripTypeCombobox = new ComboBox(tripTypeOptions);

        ObservableList<String> transportTypeOptions = FXCollections.observableArrayList(
                Constants.StringEmpty,
                Constants.Car,
                Constants.Train,
                Constants.Bus,
                Constants.Plain);

        ComboBox transportTypeCombobox = new ComboBox(transportTypeOptions);

        ObservableList<String> nightTypeOptions = FXCollections.observableArrayList(
                Constants.StringEmpty,
                Constants.Seven,
                Constants.Ten,
                Constants.Fourteen,
                Constants.TwentyOne);

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

        grid.getColumnConstraints().addAll(new ColumnConstraints(150), new ColumnConstraints(200),
                new ColumnConstraints(150), new ColumnConstraints(150), new ColumnConstraints(150),
                new ColumnConstraints(150), new ColumnConstraints(150));

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(grid);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.pannableProperty().set(true);

        String[] names = new String[] {"Tour Name", "Program", "Start date", "Description", "Food", "Nights", "Transport", "Tour Type", "Price"};

        for(int i = 0; i < names.length; i++){
            Label headerLabel = new Label(names[i]);
            headerLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
            grid.add(headerLabel, i, 10);
        }

        searchButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 11);

                String tripTypeSelected = (String) tripTypeCombobox.getSelectionModel().getSelectedItem();
                String foodTypeSelected = (String) foodTypeCombobox.getSelectionModel().getSelectedItem();
                String transportSelected = (String) transportTypeCombobox.getSelectionModel().getSelectedItem();
                String nightsSelected = (String) nightTypeCombobox.getSelectionModel().getSelectedItem();
                Boolean priceSort = sortByPrice.selectedProperty().getValue();
                Boolean nightsSort = sortByNights.selectedProperty().getValue();

                TripType tripType = UIValueMapper.uIStringToTripType().get(tripTypeSelected);
                Food food = UIValueMapper.uIStringToFoodType().get(foodTypeSelected);
                Transport transport = UIValueMapper.uIStringToTransportType().get(transportSelected);
                
                PredicateBuilder pb = new PredicateBuilder();
                QueryBuilder qb = new QueryBuilder();

                if(tripType != null){
                    pb.setTripTypeFilter(tripType);
                }
                if(food != null){
                    pb.setFoodFilter(food);
                }
                if(transport != null){
                    pb.setTransportFilter(transport);
                }
                if(nightsSelected != null && !nightsSelected.equals("")){
                    pb.setNightsFilter(Integer.parseInt(nightsSelected));
                }
                if(priceSort){
                    qb.setSortType(SortType.SortByPrice);
                } 
                else if (nightsSort){
                    qb.setSortType(SortType.SortByNights);
                }

                Query query = qb.setPredicate(pb.build()).build();

                int k = 11;

                DataContext ctx = DataContext.getDataContext();

                ArrayList<Voucher> vouchers = QueryHandler.perform(ctx.vouchers, query);

                for (int i = 0; i < vouchers.size(); i++) {

                    Label lbl = new Label(vouchers.get(i).getTourName());
                    grid.add(lbl, 0, k);

                    Label lbl2 = new Label(vouchers.get(i).getProgram());
                    grid.add(lbl2, 1, k);

                    Label lbl3 = new Label(vouchers.get(i).getStartDate().toString());
                    grid.add(lbl3, 2, k);

                    Label lbl4 = new Label(vouchers.get(i).getDescription());
                    grid.add(lbl4, 3, k);

                    Label lbl5 = new Label(vouchers.get(i).getFood().toString());
                    grid.add(lbl5, 4, k);

                    Label lbl6 = new Label(String.valueOf(vouchers.get(i).getNights()));
                    grid.add(lbl6, 5, k);

                    Label lbl7 = new Label(vouchers.get(i).getTransport().toString());
                    grid.add(lbl7, 6, k);

                    Label lbl8 = new Label(vouchers.get(i).getType().toString());
                    grid.add(lbl8, 7, k);

                    Label lbl9 = new Label(String.valueOf(vouchers.get(i).getPrice()));
                    grid.add(lbl9, 8, k);
                    k++;
                }            
            }
        });

        Scene scene = new Scene(scrollPane, 600, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}