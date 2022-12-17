Read Me File

Buttons will be made clickable later, they are accessed by keys.

Navigation Through Keys:
    To click the button, just press the key of the starting letter of the button name.
    Example: New Game - Click 'n'
    Example2: Back - Click 'b'

'OOPs' principles used:
    1. Interface - healthInt implemented by Health and Health2
    2. Inheritance - Player parent class extended by Player1 and Player2
    3. Object class - Used by Player to change the toString method to print "Player1" or "Player2"
    4. Abstract class and abstract methods - Player is an abstract class with 'draw' method as abstract which
    is defined differently in both Player1 and Player2.
    5. Immutable class - Sine term class is immutable in nature as there are only getters, and every attribute
    is private and final.
    6. Exception handling - The render method in main game screen is enclosed in try - catch.
    7. Generic Programming - This is done in the Armoury class where we will associate
    an arraylist of a generic type which can hold weapons of a type. An Armoury class object will be
    an attribute of the player object.
    8. Polymorphism using inheritance - In main game screen, getPlayerInfo is a method which uses 'Player'
    type object as attribute. That can take forms of Player1 or Player2.
    9. Composition -  This is used in every game screen where various objects of different classes are
                      first declared and then instantiated in the constructor of each game screen with the help
                      of 'new' keyword.
    10. Association - This is used in every game screen where a MainClass object is first declared and then
                      assigned through the argument in the constructor of each game screen. Then we access the MainClass object whenever we have
                      to change the screen.
    11. Dependency -  This is used in MainGameScreen in the methods getPlayerHealth() and getPlayerInfo() where Player
                      class object is taken in argument and then the public method getHealth() and getName() is directly
                      used.
    12. Private methods - Some methods are made private which are not being used.
    13. Encapsulation - Attributes are made private and getters and setters are provided.
    14. Polymorphism using interfaces - In main game screen, getPlayerHealth is a method which uses 'healthInt'
    type object as input. That can take forms of Health or Health2