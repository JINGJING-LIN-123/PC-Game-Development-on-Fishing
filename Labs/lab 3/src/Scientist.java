public class Scientist extends Person{
    // fields or member variables
    private String specialty;

    // constructor
    //constructor 1
    public Scientist(String name, int age, String SSN, String passwd) {
        // call Person's constructor
        super(name, age, SSN, passwd);
        this.specialty = "ComputerScience";
    }
    //constructor 2
    public Scientist(String name, int age, String SSN, String passwd, String specialty) {
        // call Person's constructor
        super(name, age, SSN, passwd);
        if(specialty.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        this.specialty = specialty;
    }
    //create Getter
    public String getSpecialty(){
        return this.specialty;
    }
    //create Setter
    public void setSpecialty(String specialty){
        if(specialty.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        this.specialty = specialty;
    }
    //toString
    @Override
    public String toString() {
        // string concatenation
        return "This is Scientist Name: " + getName() + " Specialty: " + getSpecialty();
    }
}
