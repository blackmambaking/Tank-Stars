Read Me

Buttons will be made clickable later, they are accessed by keys.

Navigation Through Keys:
To click the button, just press the key starting the button name.
Example: New Game - Click 'n'

OOPS principles used:
1. Interface - healthInt implemented by Health and Health2
2. Inheritance - Player parent class extended by Player1 and Player2
3. Object class - Used by Player to change the toString method to print "Player1" or "Player2"
4. Abstract class and abstract methods - Player is an abstract class with 'draw' method as abstract which
is defined differently in both Player1 and Player2.
5. Immutable class - Sine term class is immutable in nature as there are only getters, and every attribute
is private and final.
6. Exception handling - The render method in main game screen is enclosed in try - catch.
7. Generic Programming -
8. Polymorphism using inheritance - In main game screen, getPlayerInfo is a method which uses 'Player'
type object as attribute. That can take forms of Player1 or Player2.
9. Composition -
10. Association -
11. Dependency -
12. Private methods - Some methods are made private which are not being used.
13. Encapsulation - Attributes are made private and getters and setters are provided.
14. Polymorphism using interfaces - In main game screen, getPlayerHealth is a method which uses 'healthInt'
type object as input. That can take forms of Health or Health2