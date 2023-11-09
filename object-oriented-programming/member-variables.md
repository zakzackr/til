## Member variables consist of "instance variables" and "class variables".

## Instance Variables  
Instance variables are unique to the specific instance (object) in a class. When you update an instance variable, it does not affect other instance variables. Using instance-name.variable-name will usually allow you to access the specific instance variable in a class.

## Class Variables  
Class variables are shared within a class, among all instances in that class. If you update a class variable, all instances in the class will be affected. Class variables should be declared with the static keyword and will be accessed by Class-name.variable-name.  
By defining class variables with the final keyword, in addition to the static keyword, you will not be able to change class variables. This helps prevent any side effects.
