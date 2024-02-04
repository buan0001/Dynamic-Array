import java.util.Scanner;

// import Person;

public class DynamicArray {

  int INITIAL_SIZE = 10;
  String[] personArray = new String[INITIAL_SIZE];
  int spotsTaken = 0;

  public DynamicArray() {
    for (int i = 0; i < 20; i++) {
      if (personArray.length <= spotsTaken) {
        grow();
      }
      personArray[i] = "test string" + i;
      spotsTaken++;
    }
  }

  public void add(String person) {
    if (personArray.length <= spotsTaken) {
      grow();
    }
    personArray[spotsTaken] = person;
    print();
    // System.out.print("person array: " + print(personArray));
    spotsTaken++;
  }

  public void addAll(String... element) {
    for (int i = 0; i < element.length; i++) {
      System.out.println(element[i]);
      if (personArray.length <= spotsTaken) {
        grow();
      }
      personArray[spotsTaken] = element[i];
      spotsTaken++;
    }
    print();
  }

  public String get(int index) {
    return personArray[index];
  }

  public int size() {
    System.out.println("length: " + spotsTaken);
    return spotsTaken;
  }

  public void set(int index, String person) {
    personArray[index] = person;
    print();
  }

  public void remove() {
    personArray[size() - 1] = null;
    spotsTaken--;
    if (canShrink()) {
      shrink();
    }
    print();
  }

  public void remove(int index) {
    personArray[index] = null;
    spotsTaken--;
    for (int i = index; i < personArray.length - 1; i++) {
      personArray[i] = personArray[i + 1];
    }
    if (canShrink()) {
      shrink();
    }
    print();
  }

  public void insert(int index, String entry) {
    if (personArray.length <= spotsTaken) {
      grow();
    }

    for (int i = personArray.length - 1; i > index; i--) {
      System.out.println("i: " + i);
      personArray[i] = personArray[i - 1];
    }
    System.out.println("we looped");
    personArray[index] = entry;
    spotsTaken++;
    print();
  }

  public void clear() {
    for (int i = 0; i < personArray.length; i++) {
      personArray[i] = null;
    }
    if (canShrink()) {
      shrink();
    }
    print();
  }

  public void print() {
    System.out.println("spots taken: " + spotsTaken);
    for (String person : personArray) {
      System.out.println(person);
    }
  }

  private void grow() {
    String[] tempArray = new String[personArray.length + INITIAL_SIZE];
    for (int i = 0; i < personArray.length; i++) {
      tempArray[i] = personArray[i];
    }
    personArray = tempArray;
    System.out.println("Grew " + personArray.length);
    // print();
  }

  private boolean canShrink() {
    boolean check =
      personArray.length > spotsTaken + INITIAL_SIZE &&
      personArray.length - INITIAL_SIZE >= INITIAL_SIZE;
    System.out.println("check:@@@@@@@@@@ " + check);
    return check;
  }

  private void shrink() {
    String[] tempArray = new String[personArray.length - INITIAL_SIZE];
    for (int i = 0; i < tempArray.length; i++) {
      tempArray[i] = personArray[i];
    }
    personArray = tempArray;
    // print();
  }
}
