## Composition (HAS-A relationship)
Composition is a strong type of “HAS-A” relationship because the containing object(Person objects) owns the other objects(BMI/Name objects). The Person HAS-A BMI/Name.   
    
The objects’ lifecycles are tied, which means that if we delete the owner (Person) object, its members (BMI/Name objects) also will be deleted with it.   


What distinguishes composition from aggregation, that it does involve owning. 
    
ref: https://www.baeldung.com/java-composition-aggregation-association


