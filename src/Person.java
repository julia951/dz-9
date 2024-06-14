class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Person partner;
    protected String previousLastName;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
        this.previousLastName = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRetired() {
        return false; // Default implementation
    }

    public void registerPartnership(Person partner) {
        this.partner = partner;
        if (partner != null && partner instanceof Man) {
            this.previousLastName = this.lastName;
            this.lastName = partner.getLastName();
        }
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (revertLastName && this.previousLastName != null) {
            this.lastName = this.previousLastName;
        }
        this.partner = null;
    }
}

class Man extends Person {

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.age > 65;
    }
}

class Woman extends Person {

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.age > 60;
    }
}
