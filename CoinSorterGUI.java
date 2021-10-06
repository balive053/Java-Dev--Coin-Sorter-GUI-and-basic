
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoinSorterGUI extends Application {

	CoinSorter Bob = new CoinSorter();
	
	public void start(Stage stage) 
	{
		// Creating main menu nodes
		Text welcome = new Text(80, 40, "***Coin Sorter - Main Menu***");
		welcome.setFill(Color.BLACK);
		welcome.setFont(Font.font("Verdana", 14));
		Button but1 = new Button("Coin calculator");
		Button but2 = new Button("Multiple coin calculator");
		Button but3 = new Button("Print coin list");
		Button but4 = new Button("Set details");
		Button but5 = new Button("Display program configurations");
		Button but6 = new Button("Quit the program");
		
		// Setting main menu nodes size
		welcome.setLineSpacing(8);
		but1.setPrefWidth(200);
		but2.setPrefWidth(200);
		but3.setPrefWidth(200);
		but4.setPrefWidth(200);
		but5.setPrefWidth(200);
		but6.setPrefWidth(200);
		
		// Arranging layout of main menu
		VBox buttonBox = new VBox(8);         
		buttonBox.setAlignment(Pos.CENTER); 
		buttonBox.getChildren().addAll(welcome, but1, but2, but3, but4, but5, but6);
		HBox root = new HBox(30); 
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(buttonBox);
		
		
		// Button 1 (Coin Calculator)
		// Creating nodes for button 1 (Coin calculator)
		TextField but1In = new TextField();
		but1In.setMaxWidth(50);
		TextField but1Out = new TextField();
		but1Out.setMaxWidth(50);   
		Label headerLabel = new Label("Please enter amount of money you want exchanged:");  
		headerLabel.setFont(Font.font("Arial", 20));		
		Label inputAmountLabel = new Label("Amount to change:");               
		inputAmountLabel.setFont(Font.font("Arial", 16));         
		Label returnPrefLabel= new Label("Preferred return value: ");                
		returnPrefLabel.setFont(Font.font("Arial", 16));
		TextArea feedback = new TextArea();        
		feedback.setEditable(false);         
		feedback.setMinSize(450,50); 
		feedback.setMaxSize(450,50);
		
		
		// Create and configure the perform calculations button        
		Button calculateButton = new Button();         
		calculateButton.setText("Calculate");        
		calculateButton.setOnAction( e ->                     
				{   
					// Create test to check if coin list is valid
					testCoinSorter test = new testCoinSorter();
					// Check that fields are not empty     
					if(but1In.getText().isEmpty() || but1Out.getText().isEmpty())        
					{                               
						feedback.setText("Please enter an amount in the boxes above.");                       
					} else if (Integer.parseInt(but1In.getText()) > Bob.maxCoinIn)
					{
						feedback.setText("Outside range. Please enter valid amount or change parametres.");
					} 
					// Check if coin list is valid
					else if (!test.coinListHolder().contains(Integer.parseInt(but1Out.getText())))
					{
						feedback.setText("Invalid denomination. Please choose valid denomination.");
					} 
					// Check values are positive
					else if (Integer.parseInt(but1In.getText()) < 0 || Integer.parseInt(but1Out.getText()) < 0)
					{
						feedback.setText("Invalid value. Must insert positive value.");
					}
					else
					// Return result
					{     
						// Convert text input to ints
						Bob.coinCalculator(Integer.parseInt(but1In.getText()), 
								Integer.parseInt(but1Out.getText()));
						
						feedback.setText(Bob.coinCalculator(Integer.parseInt(but1In.getText()), 
								Integer.parseInt(but1Out.getText())));                        
					}                                                                        
				}); 
							
		
		// Creating boxes for layout of button 1 (Coin Calculator)
		VBox inputComponents = new VBox(14);
		inputComponents.getChildren().addAll(inputAmountLabel, returnPrefLabel);
		inputComponents.setAlignment(Pos.CENTER);
		VBox inputComponents2 = new VBox(10);
		inputComponents2.getChildren().addAll(but1In, but1Out);
		inputComponents2.setAlignment(Pos.CENTER);
		HBox inputComp2 = new HBox(30);
		inputComp2.getChildren().addAll(inputComponents, inputComponents2);
		inputComp2.setAlignment(Pos.CENTER);
		VBox holdAll = new VBox(20);
		holdAll.getChildren().addAll(headerLabel, inputComp2, calculateButton, feedback);
		holdAll.setAlignment(Pos.CENTER);
		
		// Setting scene for button 1 (Coin Calculator)
		Scene scene2 = new Scene(holdAll, 850, 250);		
		
		
		// Set action for clicking on button 1 (Coin Calculator)
		but1.setOnAction(e -> 
		{
			Stage button1stage = new Stage();
			button1stage.setScene(scene2);
			button1stage.setTitle("Coin Sorter");
			button1stage.show();
			but1In.clear();
			but1Out.clear();
			feedback.clear();
		});
		
		
			//Button 2 (Multiple Coin Calculator)
			//Creating nodes for button 2 (Multiple Coin Calculator)
			TextField but2In = new TextField();
			but2In.setMaxWidth(50);
			TextField but2Out = new TextField();
			but2Out.setMaxWidth(50);   
			Label multiHeaderLabel = new Label("Please enter amount of money you want exchanged:");  
			multiHeaderLabel.setFont(Font.font("Arial", 20));		
			Label multiInputAmountLabel = new Label("Amount to change:");               
			multiInputAmountLabel.setFont(Font.font("Arial", 16));         
			Label multiReturnPrefLabel= new Label("Denomination not wanted: ");                
			multiReturnPrefLabel.setFont(Font.font("Arial", 16));
			TextArea multiFeedback = new TextArea();        
			multiFeedback.setEditable(false);         
			multiFeedback.setMinSize(450,50); 
			multiFeedback.setMaxSize(450,50);
			
			
			// Create and configure the perform calculations button        
			Button multiCalculateButton = new Button();         
			multiCalculateButton.setText("Calculate");        
			multiCalculateButton.setOnAction( e ->                     
					{   
						// Create test to check if coin list is valid
						testCoinSorter test = new testCoinSorter();
						// Check that fields are not empty     
						if(but2In.getText().isEmpty() || but2Out.getText().isEmpty())        
						{                               
							multiFeedback.setText("Please enter an amount in the boxes above.");                       
						} 
						else if (Integer.parseInt(but2In.getText()) > Bob.maxCoinIn)
						{
							multiFeedback.setText("Outside range. Please enter valid amount or change parametres.");
						}  
						// Check if coin list is valid
						else if (!test.coinListHolder().contains(Integer.parseInt(but2Out.getText())))
						{
							multiFeedback.setText("Invalid denomination. Please choose valid denomination to exclude.");
						}
						// Check values are positive
						else if (Integer.parseInt(but2In.getText()) < 0 || Integer.parseInt(but2Out.getText()) < 0)
						{
							multiFeedback.setText("Invalid value. Must insert positive value.");
						}
						else 
						{     
							// Convert text input to ints
							multiFeedback.setText(Bob.multiCoinCalculator(Integer.parseInt(but2In.getText()), 
									Integer.parseInt(but2Out.getText())));    
							
						}                                                                        
					}                                     
				); 
							
				
				
				// Creating boxes for layout of button 2 (Multi Coin Calculator)
				VBox multiInputComponents = new VBox(14);
				multiInputComponents.getChildren().addAll(multiInputAmountLabel, multiReturnPrefLabel);
				multiInputComponents.setAlignment(Pos.CENTER);
				VBox multiInputComponents2 = new VBox(10);
				multiInputComponents2.getChildren().addAll(but2In, but2Out);
				multiInputComponents2.setAlignment(Pos.CENTER);
				HBox multiInputComp2 = new HBox(30);
				multiInputComp2.getChildren().addAll(multiInputComponents, multiInputComponents2);
				multiInputComp2.setAlignment(Pos.CENTER);
				VBox multiHoldAll = new VBox(20);
				multiHoldAll.getChildren().addAll(multiHeaderLabel, multiInputComp2, multiCalculateButton, multiFeedback);
				multiHoldAll.setAlignment(Pos.CENTER);
				
				// Setting scene for button 2 (Multi Coin Calculator)
				Scene multiScene2 = new Scene(multiHoldAll, 850, 250);		
				
				
				// Set action for clicking on button 2 (Multi Coin Calculator)
				but2.setOnAction(e -> 
				{
					Stage button2stage = new Stage();
					button2stage.setScene(multiScene2);
					button2stage.setTitle("Multi Coin Calculator");
					button2stage.show();
					but2In.clear();
					but2Out.clear();
					multiFeedback.clear();
				});
				
				
		
		//Button 3 
		// Creating display pop-up for button 3 (Print coin list)
		but3.setOnAction(new EventHandler<ActionEvent>() 
		{
			
            public void handle(ActionEvent event) 
			{
            	// Generates information to display for coinlist
                Label textLabel = new Label(("The current coin denominations are in circulation: " 
            	+ Bob.printCoinList() + "."));
 
                // Creates new window for display
                StackPane layout = new StackPane();
                layout.getChildren().add(textLabel);
                Scene secondScene = new Scene(layout, 550, 100);
                Stage coinCalcWindow = new Stage();
                coinCalcWindow.setTitle("Coin List");
                coinCalcWindow.setScene(secondScene);
                coinCalcWindow.show();
			}
		});
		
		
		// Button 4 (Setter menu button)
		// Create nodes for new menu
		Text welcomeSetter = new Text(80, 40, "***Set Details Sub-Menu***");
		Button setCurBut = new Button("Set currency");
		Button setMinVal = new Button("Set minimum coin input value");
		Button setMaxVal = new Button("Set maximum coin input value");
		Button returnToMenu = new Button("Return to main menu");
		
		// Set node sizes
		welcomeSetter.setLineSpacing(8);
		setCurBut.setPrefWidth(200);
		setMinVal.setPrefWidth(200);
		setMaxVal.setPrefWidth(200);
		returnToMenu.setPrefWidth(200);
		
		// Arranging layout of main menu
		VBox setterBox = new VBox(8);         
		setterBox.setAlignment(Pos.CENTER); 
		setterBox.getChildren().addAll(welcomeSetter, setCurBut, setMinVal, setMaxVal, returnToMenu);
		HBox hSetter = new HBox(30); 
		hSetter.setAlignment(Pos.CENTER);
		hSetter.getChildren().addAll(setterBox);
		
		// Create new scene 
		Scene setterScene = new Scene(hSetter, 550, 250);		
				
		// Set action for clicking on button 4 
		but4.setOnAction(e -> 
		{
			Stage setterStage = new Stage();
			setterStage.setScene(setterScene);
			setterStage.setTitle("Setter Details");
			setterStage.show();
			
			// Setting return to main menu button function
						returnToMenu.setOnAction(g -> 
						{
							setterStage.close();
						});
			
			
		});
		
			// Create 'set currency' interface
			TextField setCurrency = new TextField();
			setCurrency.setMaxWidth(120); 
			setCurrency.setMinWidth(120); 
			Label setCurrencyLabel = new Label("Enter desired currency");  
			setCurrencyLabel.setFont(Font.font("Arial", 14));	
			Label setCurrencyFeedbackLabel = new Label();  
			setCurrencyFeedbackLabel.setFont(Font.font("Arial", 12));
			Button setCurOK = new Button();
			setCurOK.setMaxWidth(60);
			setCurOK.setMinWidth(60);
			setCurOK.setText("OK");
			HBox setCurHBox = new HBox(30);
			setCurHBox.setAlignment(Pos.CENTER);
			setCurHBox.getChildren().addAll(setCurrencyLabel, setCurrency);
			VBox setCurVBox = new VBox(10);
			setCurVBox.setAlignment(Pos.CENTER);
			setCurVBox.getChildren().addAll(setCurHBox, setCurOK, setCurrencyFeedbackLabel);
		
			// Create new scene 
			Scene setCurScene = new Scene(setCurVBox, 400, 120);		
					
				// Set action for clicking on Set Currency button 
				setCurBut.setOnAction(e -> 
				{
					// Create new stage to ask for currency
					Stage setCurStage = new Stage();
					setCurStage.setScene(setCurScene);
					setCurStage.setTitle("Set new currency");
					setCurStage.show();
					
					// Check new currency has been entered and set action of OK button to confirm
					setCurOK.setOnAction(g ->
					{
						if(setCurrency.getText().isEmpty())        
						{                               
							setCurrencyFeedbackLabel.setText("Please enter desired currency e.g. Dollars and click OK");                       
						}  
						else                        
						{     
							// Set new currency, clear field, and close window
							Bob.setCurrency(setCurrency.getText());
							setCurStage.close();
							setCurrency.clear();
						}
					});
				});
				
			// Create 'set minimum' interface
			TextField setMinimum = new TextField();
			setMinimum.setMaxWidth(120); 
			setMinimum.setMinWidth(120); 
			Label setMinimumLabel = new Label("Enter new mimimum");  
			setMinimumLabel.setFont(Font.font("Arial", 14));	
			Label setMinimumFeedbackLabel = new Label();  
			setMinimumFeedbackLabel.setFont(Font.font("Arial", 10));
			Button setMinimumOK = new Button();
			setMinimumOK.setMaxWidth(60);
			setMinimumOK.setMinWidth(60);
			setMinimumOK.setText("OK");
			HBox setMinimumHBox = new HBox(30);
			setMinimumHBox.setAlignment(Pos.CENTER);
			setMinimumHBox.getChildren().addAll(setMinimumLabel, setMinimum);
			VBox setMinimumVBox = new VBox(10);
			setMinimumVBox.setAlignment(Pos.CENTER);
			setMinimumVBox.getChildren().addAll(setMinimumHBox, setMinimumOK, setMinimumFeedbackLabel);
		
			// Create new scene 
			Scene setMinScene = new Scene(setMinimumVBox, 400, 120);		
					
				// Set action for clicking on Set Minimum button 
				setMinVal.setOnAction(e -> 
				{
					// Create new stage to ask for new minimum
					Stage setMinStage = new Stage();
					setMinStage.setScene(setMinScene);
					setMinStage.setTitle("Set new minimum input");
					setMinStage.show();
					
					// Check new minimum has been entered and set action of OK button to confirm
					setMinimumOK.setOnAction(g ->
					{
						if(setMinimum.getText().isEmpty())        
						{                               
							setMinimumFeedbackLabel.setText("Please enter desired minimum e.g. 0 and click OK");                       
						}  
						else if (Integer.parseInt(setMinimum.getText()) > Bob.MaxCoinIn() 
								|| Integer.parseInt(setMinimum.getText()) < 0)
						{
							setMinimumFeedbackLabel.setText("Invalid input. Must be smaller than maximum and positive."
									+ "Current maximum is " + Bob.MaxCoinIn() + ".");
						}
						else                        
						{     
							// Set new minimum, clear field, and close window
							Bob.setMinCoinIn(Integer.parseInt(setMinimum.getText()));
							setMinStage.close();
							setMinimum.clear();
						}
					});
				});	
			
			// Create 'set maximum' interface
			TextField setMaximum = new TextField();
			setMaximum.setMaxWidth(120); 
			setMaximum.setMinWidth(120); 
			Label setMaximumLabel = new Label("Enter new maximum");  
			setMaximumLabel.setFont(Font.font("Arial", 14));	
			Label setMaximumFeedbackLabel = new Label();  
			setMaximumFeedbackLabel.setFont(Font.font("Arial", 10));
			Button setMaximumOK = new Button();
			setMaximumOK.setMaxWidth(60);
			setMaximumOK.setMinWidth(60);
			setMaximumOK.setText("OK");
			HBox setMaximumHBox = new HBox(30);
			setMaximumHBox.setAlignment(Pos.CENTER);
			setMaximumHBox.getChildren().addAll(setMaximumLabel, setMaximum);
			VBox setMaximumVBox = new VBox(10);
			setMaximumVBox.setAlignment(Pos.CENTER);
			setMaximumVBox.getChildren().addAll(setMaximumHBox, setMaximumOK, setMaximumFeedbackLabel);
				
			// Create new scene 
			Scene setMaxScene = new Scene(setMaximumVBox, 400, 120);		
					
				// Set action for clicking on Set Maximum button 
				setMaxVal.setOnAction(e -> 
				{
					// Create new stage to ask for new maximum
					Stage setMaxStage = new Stage();
					setMaxStage.setScene(setMaxScene);
					setMaxStage.setTitle("Set new maximum input");
					setMaxStage.show();
							
					// Check new maximum has been entered and set action of OK button to confirm
					setMaximumOK.setOnAction(g ->
					{
						if(setMaximum.getText().isEmpty())        
						{                               
							setMaximumFeedbackLabel.setText("Please enter desired maximum e.g. 1000 and click OK");                       
						}  
						else if (Integer.parseInt(setMaximum.getText()) < Bob.MinCoinIn() || 
								Integer.parseInt(setMaximum.getText()) < 0) 
						{
							setMaximumFeedbackLabel.setText("Invalid input. Must be bigger than minimum and positive."
									+ "Current minimum is " + Bob.MinCoinIn() + ".");
						}
						else                        
						{     
							// Set new maximum, clear field, and close window
							Bob.setMaxCoinIn(Integer.parseInt(setMaximum.getText()));
							setMaxStage.close();
							setMaximum.clear();
						}
					});
				});	
			
				
		//Button 5 (Display program configurations)
		// Creating display pop-up for button 5 (Display program configurations)
				but5.setOnAction(new EventHandler<ActionEvent>() 
				{
					public void handle(ActionEvent event) 
					{
		            	// Calling display configurations
		                Label textLabel = new Label((Bob.displayProgramConfigs()));
		 
		                // Creates and show stage and scene
		                StackPane layout = new StackPane();
		                layout.getChildren().add(textLabel);
		                Scene secondScene = new Scene(layout, 550, 100);
		                Stage displayWindow = new Stage();
		                displayWindow.setTitle("Program Configurations");
		                displayWindow.setScene(secondScene);
		                displayWindow.show();
					}
				});
		
				
		//Button 6 (Close menu)
				// Implement close menu button
				but6.setOnAction(e -> 
				{
					stage.close();
				});
		
		// Setting and calling main scene
		Scene scene = new Scene(root, 450, 425, Color.LIGHTGRAY); 
		stage.setScene(scene);
		stage.setTitle("Coin Sorter");
		stage.show();
	
	} 
	
} 
