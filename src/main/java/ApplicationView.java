
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.util.ArrayList;

public class ApplicationView extends Application {

    private Canvas gameCanvas;
    private Scene gameScene;
    private Group gameGroup;

    Stage window;

    Label infoLabel;
    Button termsButton;
    Button tipsButton;
    Button searchButton;
    Button compareButton;
    Button playButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Waste and Energy Analyzer");

        termsButton = new Button("Terms");
        termsButton.setMinWidth(75);
        tipsButton = new Button("Tips");
        tipsButton.setMinWidth(75);
        searchButton = new Button("Search");
        searchButton.setMinWidth(75);
        compareButton = new Button("Compare");
        compareButton.setMinWidth(75);
        playButton = new Button("Play");
        playButton.setMinWidth(75);

        termsButton.setOnAction(e -> {
            showTerms();
        });
        tipsButton.setOnAction(e -> {
            showTips();
        });
        searchButton.setOnAction(e -> {
            searchCountry();
        });
        compareButton.setOnAction(e -> {
            compareCountries();
        });

        VBox buttonsLayout = new VBox(20);

        buttonsLayout.getChildren().addAll(termsButton,tipsButton,searchButton,compareButton,playButton);
        buttonsLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(buttonsLayout, 300, 300);
        window.setScene(scene);
        window.show();

    }

    public void showTerms() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Important Terminology");
        window.setMinWidth(250);
        window.setMinHeight(500);

        Label terms = new Label("terms");
        terms.setAlignment(Pos.CENTER);

        Scene scene = new Scene(terms);
        window.setScene(scene);
        window.showAndWait();
    }

    public void showTips() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Important Tips");
        window.setMinWidth(250);
        window.setMinHeight(500);

        Label tips = new Label("tips");
        tips.setAlignment(Pos.CENTER);

        Scene scene = new Scene(tips);
        window.setScene(scene);
        window.showAndWait();
    }

    public void searchCountry() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Search Country Data");
        window.setMinWidth(300);
        window.setMinHeight(600);

        ChoiceBox<String> dataDropdown = new ChoiceBox<>();
        dataDropdown.getItems().addAll("Energy", "Waste");
        dataDropdown.setValue("Energy");

        TextField countryText = new TextField();
        countryText.setText("United States");

        Button searchButton = new Button();
        searchButton.setText("Search");

        HBox inputLayout = new HBox(10);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.getChildren().addAll(countryText,searchButton);

        Label dataLabel = new Label();
        dataLabel.setAlignment(Pos.CENTER);

        searchButton.setOnAction(e -> {
            String country = countryText.getText();
            String data = dataDropdown.getValue();
            if (country.equals("United States")) {
                if (data.equals("Energy")) {
                    dataLabel.setText("");
                } else if (data.equals("Waste")) {
                    dataLabel.setText("The total generation of municipal\n" +
                            "solid waste (MSW) in 2018 \n" +
                            "was 292.4 million tons (U.S. \n" +
                            "short tons, unless specified) \n" +
                            "or 4.9 pounds per person per day.\n\n" +
                            "Landfilling of waste has decreased \n" +
                            "from 94 percent of the amount generated\n" +
                            "in 1960 to 50 percent of the amount \n" +
                            "generated in 2018.\n\n" +
                            "The generation of paper and paperboard,\n" +
                            "the largest material component of MSW, \n" +
                            "fluctuates from year to year, but has \n" +
                            "decreased from 87.7 million tons in 2000\n" +
                            "to 67.4 million tons in 2018.");
                }
            } else if (country.equals("Mexico")) {
                if (data.equals("Energy")) {
                    dataLabel.setText("");
                } else if (data.equals("Waste")) {
                    dataLabel.setText("In 2017, Mexico generated around \n" +
                            "44 million tons of waste, or \n" +
                            "0.94 kilograms per person per day.\n\n" +
                            "The State of Mexico, Mexico City, \n" +
                            "and Jalisco together generate 28.5% \n" +
                            "of the country's waste. Approximately \n" +
                            "10% of the solid waste generated in \n" +
                            "Mexico’s cities is recycled \n" +
                            "(Secretariat for the Environment and \n" +
                            "Natural Resources, SEMARNAT, 2010), \n" +
                            "whereas 70% ends up in landfills and \n" +
                            "the remaining 20% is disposed of in \n" +
                            "illegal dumpsites.\n\n" +
                            "70% is household waste, 30% comes from \n" +
                            "other sources. SEMARNAT reports in 2020 \n" +
                            "that 46% of the waste is organic in \n" +
                            "nature, which is relatively low compared \n" +
                            "to other countries studied by the project \n" +
                            "team. Moreover, 32% of the waste could be \n" +
                            "recycled (e.g., cardboard, paper, plastics, \n" +
                            "glasses) and 22% is residual waste.");
                }
            } else if (country.equals("Canada")) {
                if (data.equals("Energy")) {
                    dataLabel.setText("");
                } else if (data.equals("Waste")) {
                    dataLabel.setText("");
                }
            } else {
                dataLabel.setText("Invalid country...");
            }
        });

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(dataDropdown, inputLayout,dataLabel);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public void compareCountries() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Compare Country Data");
        window.setMinWidth(250);
        window.setMinHeight(300);

        ChoiceBox<String> dataDropdown = new ChoiceBox<>();
        dataDropdown.getItems().addAll("Energy", "Waste");
        dataDropdown.setValue("Energy");

        TextField country1Text = new TextField();
        country1Text.setText("United States");

        TextField country2Text = new TextField();
        country2Text.setText("United States");

        Button compareButton = new Button();
        compareButton.setText("Compare");

        VBox inputLayout = new VBox(10);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setMaxWidth(200);
        inputLayout.getChildren().addAll(country1Text,country2Text,compareButton);

        Label dataLabel = new Label();
        dataLabel.setText("INSERT DATA HERE");
        dataLabel.setAlignment(Pos.CENTER);

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(dataDropdown,inputLayout,dataLabel);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
