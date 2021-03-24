package hw1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookApp {
    public static void main(String [] args) throws Exception {
        try {
            if (args.length != 1) {
                System.out.println("Usage: PhonebookApp 'phonebook-filename'");
                System.exit(1);
            }

            Phonebook phonebook = new Phonebook(args[0]);

            Scanner keyboard = new Scanner(System.in);

            System.out.print("lookup, quit (l/q)? ");
            String choice = keyboard.next();
            while (!choice.equals("q")) {
                if (choice.equals("l")) {
                    System.out.print("last name? ");
                    String lname = keyboard.next();
                    System.out.print("first name? ");
                    String fname = keyboard.next();

                    PhonebookEntry result = phonebook.lookup(new Name(lname, fname));
                    if (result != null) {
                        System.out.println(result.getName() + "'s phone numbers: " + result.getPhoneNumbers());
                    } else {
                        System.out.println("-- Name not found");
                    }
                } else {
                    System.out.println("Invalid choice -- please enter an 'l' or a 'q' for your choice");
                }
                System.out.println();
                System.out.print("lookup, quit (l/q)? ");
                choice = keyboard.next();
            }
        } catch (IOException e) {
            System.out.println("*** IOException *** " + e.getMessage());
        } catch (Exception e) {
            System.out.println("*** Exception *** " + e.getMessage());
        }
    }
}

class Phonebook {
    private Map<Name, PhonebookEntry> map;

    public Phonebook(String phonebookName) throws Exception {
        map = new TreeMap<Name, PhonebookEntry>();
        Scanner scanner = new Scanner(new File(phonebookName));

        PhonebookEntry entry = PhonebookEntry.read(scanner);
        while (entry != null) {
            map.put(entry.getName(), entry);
            entry = PhonebookEntry.read(scanner);
        }
    }

    public PhonebookEntry lookup(Name name) {
        PhonebookEntry result = map.get(name);
        return result == null? result : new PhonebookEntry(result);
    }
}

class PhonebookEntry {
    private Name name;
    private ArrayList<ExtendedPhoneNumber> phoneNumbers;

    public PhonebookEntry(Name name, ArrayList<ExtendedPhoneNumber> phoneNumbers) {
        this.name = new Name(name);
        this.phoneNumbers = new ArrayList<ExtendedPhoneNumber>(phoneNumbers);
    }

    public PhonebookEntry(PhonebookEntry other) {
        this.name = new Name(other.name);
        this.phoneNumbers = new ArrayList<ExtendedPhoneNumber>(other.phoneNumbers);
    }

    public Name getName() { return new Name(name); }

    public ArrayList<ExtendedPhoneNumber> getPhoneNumbers() {
        return new ArrayList<ExtendedPhoneNumber>(phoneNumbers);
    }

    public String toString() { return name + ": " + phoneNumbers; }

    public static PhonebookEntry read(Scanner scanner) {
        if (!scanner.hasNext()) 
            return null;
        Name name = Name.read(scanner);
        ArrayList<ExtendedPhoneNumber> phoneNumbers = new ArrayList<>();
        int header = scanner.nextInt();
        for (int i = 1; i <= header; i++)
            phoneNumbers.add(ExtendedPhoneNumber.read(scanner));
        return new PhonebookEntry(name, phoneNumbers);
    }
}

class Name implements Comparable<Name> {
    private String first, last;

    public Name(String last, String first) {
        this.last = last;
        this.first = first;
    }

    public Name(Name other) {
        this.first = other.first;
        this.last = other.last;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            Name other = (Name)obj;
            return this.first.equals(other.first) && this.last.equals(other.last);
        }
        else
            return false;
    }

    @Override
    public int compareTo(Name other) {
        int lastResult = this.last.compareTo(other.last);
        if (lastResult != 0)
            return lastResult;
        else
            return this.first.compareTo(other.first);
    }

    @Override
    public String toString() { return first + " " + last; }

    public static Name read(Scanner scanner) {
        if (!scanner.hasNext()) 
            return null;
        String last = scanner.next();
        String first = scanner.next();
        return new Name(last, first);
    }
}

class PhoneNumber {
    private String number;

    public PhoneNumber(String number) { this.number = number; }

    public PhoneNumber(PhoneNumber old) { this.number = old.number; }

    public boolean equals(Object obj) {
        if (obj instanceof PhoneNumber)
            return this.number.equals(((PhoneNumber)obj).number);
        else
            return false;
    }

    public String toString() { return number; }

    public static PhoneNumber read(Scanner scanner) {
        if (!scanner.hasNext()) 
            return null;
        String number = scanner.next();
        return new PhoneNumber(number);
    }
}

class ExtendedPhoneNumber extends PhoneNumber {
    private String description;

    public ExtendedPhoneNumber(String description, String number) {
        super(number);
        this.description = description;
    }

    public ExtendedPhoneNumber(ExtendedPhoneNumber old) {
        super(old);
        this.description = old.description;
    }
    
    @Override
    public String toString() {
        return description + ": " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExtendedPhoneNumber) {
            ExtendedPhoneNumber other = (ExtendedPhoneNumber)obj;
            return super.equals(other) && this.description.equals(other.description);
        }
        else
            return false;
    }    

    public static ExtendedPhoneNumber read(Scanner scanner) {
        if (!scanner.hasNext()) 
            return null;
        String description = scanner.next();
        String number = scanner.next();
        return new ExtendedPhoneNumber(description, number);
    }
}
