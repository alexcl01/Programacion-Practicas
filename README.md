# Programacion-Practica2

THIS PROGRAM IS AN UPDATED AND IMPROVED VERSION OF 'Programacion-Practica1'.
INCLUDES INHERITENCE , THE LOCALDATE CLASS, INTERNATIONALIZATION, A LOT MORE METHODS AND A TEST TO PROVE IF EVERYTHING IS GOING AS EXPECTED.

**INHERITENCE**: Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. The class which inherits the properties 
                 of other is known as subclass, and the class whose properties are inherited is known as superclass.
     
     `public class Hotel extends Reservation{`               `public class Reservation{
	                                                          //instance variables
	                                                          private String name;
	                                                          private int roomNumber;

	                                                          private ArrayList<Reservation> rooms;`
						
**LOCALDATE CLASS**: LocalDate, LocalTime and LocalDateTime classes are immutable classes that represent Date and Time 
                     with a default format of yyyy-MM-dd-HH-mm-ss.zzz in the case of LocalDateTime. 
		     
		     
      `import java.time.LocalDate;                          `// LocalDate class
       import java.time.LocalDateTime;                          LocalDate dateNow = LocalDate.now();
       import java.time.LocalTime;`	                            LocalTime timeNow = LocalTime.now();
		                                                    LocalDateTime datetimeNow = LocalDateTime.of(dateNow, timeNow);`
								  
								  
							          // On each method
								     System.out.println("Reservation did at " + datetimeNow);
								     
**INTERNATIONALIZATION**: Internationalization is the process of designing an application so that it can be adapted to various languages and 
                          regions without engineering changes. Sometimes the term internationalization is abbreviated as i18n.
			   
			  
    `// internationalization                                                                    `if(choice.equalsIgnoreCase("Change language")) {
        private static void i18n() throws IOException {                                               i18n();
	    ResourceBundle rb = ResourceBundle.getBundle("Practicas/resource_bundle");               }`
		
	    Locale.setDefault(new Locale ("es", "ES"));
        rb = ResourceBundle.getBundle("Practicas/resource_bundle");
        System.out.println(rb.getString("language"));	                                                                          
  		                                                                                      
        }`
      
      
                   
    
    
    
    
    
    
    
    
    
                                                   
 
