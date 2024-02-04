// ENDTE MED IKKE AT BRUGE DENNE FIL
// DA JEG IKKE KUNNE FINDE UD AF BENYTTE DEN RIGTIGT I DYNAMIC ARRAY-FILEN

public class Person {

  private String firstName;
  private String middleName;
  private String lastName;

  public Person(String fullName) {
    String[] splitName = fullName.split(" ");
    firstName = splitName[0];
    if (splitName.length == 2) {
      lastName = splitName[1];
    } else if (splitName.length == 1) {
      lastName = null;
    } else {
      lastName = splitName[splitName.length - 1];
      middleName = "";
      for (int i = 1; i < splitName.length - 1; i++) {
        if (i == splitName.length - 2) {
          middleName += splitName[i];
        } else {
          middleName += splitName[i] + " ";
        }
      }
      return;
    }
    System.out.println("efter loopet");
    middleName = null;
  }

  public static void main(String[] args) {
    // System.out.println(args[0]);
    Person app = new Person(args[0]);
    app.start();
  }

  public void start() {
    System.out.println(toString());
  }

  public String toString() {
    return firstName + " " + middleName + " " + lastName;
  }
}
