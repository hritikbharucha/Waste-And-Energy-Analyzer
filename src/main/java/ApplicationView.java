
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    Label titleLabel;
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

        titleLabel = new Label("Welcome to Waste and Energy Data Analyzer");
        infoLabel = new Label("Learn about sustainability and ways to take care of our planet");

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

        buttonsLayout.getChildren().addAll(titleLabel,infoLabel,termsButton,tipsButton,searchButton,compareButton,playButton);
        buttonsLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(buttonsLayout, 350, 350);
        window.setScene(scene);
        window.show();

    }

    public void showTerms() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Important Terminology");
        window.setMinWidth(350);
        window.setMinHeight(750);

        Label terms = new Label("Biofuels—Alcohols, ethers, esters, and \n" +
                "other chemicals made from raw biological \n" +
                "material such as herbaceous and woody plants, \n" +
                "agricultural and forestry residues, and a \n" +
                "large portion of municipal solid and industrial \n" +
                "waste.\n\n" +
                "Biomass—Organic waste from agricultural, livestock, \n" +
                "and lumber industry products, dead trees, foliage, \n" +
                "etc., and is considered a renewable energy source. \n" +
                "Biomass can be used as fuel and is most often burned \n" +
                "to create steam that powers steam turbine generators. \n" +
                "It is also used to make transportation fuels like \n" +
                "ethanol and biodiesel, and chemicals like pyrolysis \n" +
                "oil that can be burned like oil to produce energy.\n\n" +
                "Energy Conservation—Using less energy, either by \n" +
                "greater energy efficiency or by decreasing the types \n" +
                "of applications requiring electricity or natural gas \n" +
                "to operate.\n\n" +
                "Energy Efficiency—Using less energy (electricity and/or \n" +
                "natural gas) to perform the same function at the same \n" +
                "level of quality. Programs designed to use energy more \n" +
                "efficiently — doing the same with less. For the purpose \n" +
                "of this paper, energy efficiency is distinguished from \n" +
                "DSM programs in that the latter are utility sponsored \n" +
                "and financed, while the former is a broader term not \n" +
                "limited to any particular sponsor or funding source.\n\n" +
                "Gigawatt-hour (GWh)—The unit of energy equal to that \n" +
                "expended in one hour at a rate of one billion watts. \n" +
                "One GWh equals 1,000 megawatt-hours.\n\n" +
                "Greenhouse gases—Greenhouse gases are water vapor, \n" +
                "carbon dioxide, tropospheric ozone, nitrous oxide, \n" +
                "methane, and chlorofluorocarbons (CFCs).");
        terms.setAlignment(Pos.CENTER);

        Scene scene = new Scene(terms);
        window.setScene(scene);
        window.showAndWait();
    }

    public void showTips() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Sustainability Tips");
        window.setMinWidth(350);
        window.setMinHeight(650);

        Label tips = new Label("The key to reducing your carbon \n" +
                "footprint is to limit your energy use, and \n" +
                "consume less. That said, any behavior that \n" +
                "conserves resources—recycling is one example—will \n" +
                "reduce greenhouse gas pollution.\n\n" +
                "Here are some practical ways to cut your greenhouse \n" +
                "gas emissions:\n\n" +
                "Instant Changes\n" +
                "1. Unplug your electronics\n" +
                "Many appliances consume energy even when you’re \n" +
                "not using them. This is called “phantom load,” \n" +
                "and it can cost you $100 or more per year. Prevent \n" +
                "it by directly unplugging electronics or by plugging \n" +
                "items into a surge protector/power strip and turning \n" +
                "the whole strip off when you leave a room.\n\n" +
                "2. Adjust your thermostat\n" +
                "Turning up your air conditioning by several \n" +
                "degrees can reduce your energy bill, keeping \n" +
                "CO2 out of the air and dollars in your wallet. \n" +
                "In the winter, putting on a sweater instead of \n" +
                "blasting the heat can also save a hefty amount \n" +
                "of energy.\n\n" +
                "3. Alter your driving habits\n" +
                "   -Stop idling\n" +
                "   -Accelerate gently\n" +
                "   -Reduce your speed");
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
                    dataLabel.setText("In 2021, the electric power sector \n" +
                            "accounted for about 96% of total \n" +
                            "U.S. utility-scale electricity \n" +
                            "generation, nearly all of which was \n" +
                            "sold to the other sectors.\n\n" +
                            "In 2019, U.S. total annual energy \n" +
                            "production was greater than total annual \n" +
                            "consumption for the first time since 1957. \n" +
                            "Production also exceed consumption in 2020 \n" +
                            "and in 2021. In 2021, production equaled \n" +
                            "97.78 quads and consumption equaled 97.33 \n" +
                            "quads.");
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
                    dataLabel.setText("Mexico is one of the largest \n" +
                            "producers of petroleum and other \n" +
                            "liquids in the world. Mexico is \n" +
                            "the fourth-largest producer in the \n" +
                            "Americas after the United States, \n" +
                            "Canada, and Brazil.\n\n" +
                            "Mexico is an important partner in \n" +
                            "U.S. energy trade. In 2019, Mexico \n" +
                            "accounted for almost 600,000 barrels \n" +
                            "per day (b/d), or 9%, of all U.S. crude \n" +
                            "oil imports.");
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
                    dataLabel.setText("Canada’s energy sector accounted for\n" +
                            "approximately 8.1% of nominal Gross \n" +
                            "Domestic Product (GDP) in 2020.\n\n" +
                            "Energy exports worth $95.1 billion were \n" +
                            "sent to 142 countries, with the United \n" +
                            "States accounting for 90%. Meanwhile, \n" +
                            "Canada imported $30.9 billion of energy \n" +
                            "in 2020.\n\n" +
                            "Government revenues coming from enterprises \n" +
                            "in the energy sector were $17.1 billion in 2019.");
                } else if (data.equals("Waste")) {
                    dataLabel.setText("From 2002 to 2018, the total amount\n" +
                            "of solid waste generated in Canada \n" +
                            "increased by 4.8 million tonnes (or 16%) \n" +
                            "to reach 35.6 million tonnes.\n\n" +
                            "In that same time period, the amount \n" +
                            "of waste diverted increased by 3.2 million \n" +
                            "tonnes (or 48%) to reach 9.8 million \n" +
                            "tonnes. The amount of waste disposed in \n" +
                            "landfills or incinerated increased by 1.7 \n" +
                            "million tonnes (or 7%) to reach 25.7 \n" +
                            "million tonnes.\n\n" +
                            "In 2018, 28% of solid waste generated in \n" +
                            "Canada was diverted, while the remaining \n" +
                            "72% was sent for disposal.");
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
        window.setTitle("Compare Country Energy Usage");
        window.setMinWidth(400);
        window.setMinHeight(500);

        TextField country1Text = new TextField();
        country1Text.setText("United States");

        TextField country2Text = new TextField();
        country2Text.setText("Mexico");

        Button compareButton = new Button();
        compareButton.setText("Compare");

        VBox inputLayout = new VBox(10);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setMaxWidth(200);
        inputLayout.getChildren().addAll(country1Text,country2Text,compareButton);

        TableView tableView = new TableView();

        tableView.setMaxWidth(301.5);
        tableView.setMaxHeight(200);

        TableColumn<String,String> column1 = new TableColumn<>("Stat");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("type"));
        column1.setMinWidth(100);
        TableColumn<DataType, String> column2 =
                new TableColumn<>("");
        column2.setMinWidth(100);
        column2.setCellValueFactory(
                new PropertyValueFactory<>("data1"));
        TableColumn<DataType, String> column3 =
                new TableColumn<>("");
        column3.setMinWidth(100);
        column3.setCellValueFactory(
                new PropertyValueFactory<>("data2"));

        tableView.getColumns().addAll(column1,column2,column3);

        String canadaCommercialEnergyUse = "8,156.31";
        String canadaCrudeOilProduction = "3.86 million \nbbl/day";
        String canadaElectricityPowerConsumption = "565.73 billion";

        String usCommercialEnergyUse = "8,148.38";
        String usCrudeOilProduction = "11.11 million \nbbl/day";
        String usElectricityPowerConsumption = "4.13 trillion";

        String mexicoCommercialEnergyUse = "1,567";
        String mexicoCrudeOilProduction = "2.94 million \nbbl/day";
        String mexicoElectricityPowerConsumption = "249.67 billion";

        VBox vbox = new VBox(tableView);
        vbox.setAlignment(Pos.CENTER);

        compareButton.setOnAction(e -> {
            String country1 = country1Text.getText();
            String country2 = country2Text.getText();
            if (country1.equals("United States") && country2.equals("Canada")) {
                column2.setText("United States");
                column3.setText("Canada");
                tableView.getItems().clear();
                tableView.getItems().addAll(
                        new DataType("Commercial \nEnergy Use", usCommercialEnergyUse, canadaCommercialEnergyUse),
                        new DataType("Crude Oil \nProduction", usCrudeOilProduction, canadaCrudeOilProduction),
                        new DataType("Electric \nPower \nConsumption", usElectricityPowerConsumption, canadaElectricityPowerConsumption)
                );
            } else if (country1.equals("United States") && country2.equals("Mexico")) {
                column2.setText("United States");
                column3.setText("Mexico");
                tableView.getItems().clear();
                tableView.getItems().addAll(
                        new DataType("Commercial \nEnergy Use", usCommercialEnergyUse, mexicoCommercialEnergyUse),
                        new DataType("Crude Oil \nProduction", usCrudeOilProduction, mexicoCrudeOilProduction),
                        new DataType("Electric \nPower \nConsumption", usElectricityPowerConsumption, mexicoElectricityPowerConsumption)
                );
            } else if (country1.equals("Canada") && country2.equals("Mexico")) {
                column2.setText("Canada");
                column3.setText("Mexico");
                tableView.getItems().clear();
                tableView.getItems().addAll(
                        new DataType("Commercial \nEnergy Use", canadaCommercialEnergyUse, mexicoCommercialEnergyUse),
                        new DataType("Crude Oil \nProduction", canadaCrudeOilProduction, mexicoCrudeOilProduction),
                        new DataType("Electric \nPower \nConsumption", canadaElectricityPowerConsumption, mexicoElectricityPowerConsumption)
                );
            }
        });

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(inputLayout,tableView);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
