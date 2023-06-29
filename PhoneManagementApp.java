import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class PhoneManagementApp {

    List<Application> applicationList = new ArrayList<>();
    List<Person> personList = new ArrayList<>();

    public boolean appAddToPhone(Application app) {
        return applicationList.add(app);
    }

    public boolean appRemoveToPhone(String appName) {
        Iterator itr = applicationList.iterator();
        while (itr.hasNext()) {
            if (((Application) itr.next()).getAppName().equalsIgnoreCase(appName)) {
                itr.remove();
                return true;
            }

        }
        return false;
    }

    public boolean checkApp(String appName) {

        Optional<Application> check = applicationList.stream().filter(app -> app.getAppName().equalsIgnoreCase(appName)).findFirst();
        if (check.isPresent())
            return true;
        else
            return false;

    }

    public void appUpdateToPhone(String oldApp, Application newApp) {
        Application tempApp;
        for (Application app : applicationList) {
            if (app.getAppName().equals(oldApp)) {
                tempApp = app;
                Integer index = applicationList.indexOf(tempApp);
                tempApp.setAppName(newApp.getAppName());
                tempApp.setVersion(newApp.getVersion());
                tempApp.setDimension(newApp.getDimension());
                applicationList.set(index, tempApp);
            }
        }
    }

    public boolean checkPerson(String personName) {

        Optional<Person> check = personList.stream().filter(person -> person.getPersonName().equalsIgnoreCase(personName)).findFirst();
        if (check.isPresent())
            return true;
        else
            return false;

    }

    public Person getPerson(String personName) {
        try {
            Person checkPerson = personList.stream().filter(person -> person.getPersonName().equalsIgnoreCase(personName)).findFirst().get();

            return checkPerson;
        } catch (NoSuchElementException e) {
            return null;
        }


    }

    public void addPersontoPhone(Person person) {
        personList.add(person);
    }

    public void personUpdateToPhone(String oldPersonName, Person newPerson) {
        Person tempPerson;
        for (Person person : personList) {
            if (person.getPersonName().equalsIgnoreCase(oldPersonName)) {
                tempPerson = person;
                Integer index = personList.indexOf(tempPerson);
                tempPerson.setPersonName(newPerson.getPersonName());
                tempPerson.setPhoneNumber(newPerson.getPhoneNumber());
                tempPerson.setEmail(newPerson.getEmail());
                personList.set(index, tempPerson);
            }
        }
    }

    public boolean personRemoveToPhone(String personName) {
        Iterator itr = personList.iterator();
        while (itr.hasNext()) {
            if (((Person) itr.next()).getPersonName().equalsIgnoreCase(personName)) {
                itr.remove();
                return true;
            }
        }
        return false;
    }

    public void appPrint() {
        for (Application app : applicationList) {
            System.out.println("Uygulama Ad:" + app.getAppName());
            System.out.println("Uygulama Version:" + app.getVersion());
            System.out.println("Uygulama Boyut (MB):" + app.getDimension());
            System.out.println("**************************************");
        }
    }

    public void personPrint() {
        for (Person person : personList) {
            System.out.println("Kişi Ad-Soyad : " + person.getPersonName());
            System.out.println("Telefon: " + person.getPhoneNumber());
            System.out.println("e-Mail: " + person.getEmail());
            System.out.println("**************************************");
        }
    }

    public void phoneStorageInfo() {
        double totalStorage = DomainConstant.phone.getCapaticy();
        Double usingStorage = applicationList.stream()
                .mapToDouble(app -> app.getDimension() / 1024).sum();

        System.out.println("Telefon Kapasitesi: " + String.format("%,.2f", DomainConstant.phone.getCapaticy()) + " GB");
        System.out.println("Kullanılan Alan: " + String.format("%,.2f", usingStorage) + " GB");
        System.out.println("Boş Alan: " + String.format("%,.2f", (totalStorage - usingStorage)) + " GB");
    }

    public void restore() throws Exception {
        try {
            Scanner sc = new Scanner(new File("Backup.txt"));
            applicationList = new ArrayList<>();
            personList = new ArrayList<>();
            String[] apps;

            String readKey = sc.nextLine();
            if (readKey.trim().equalsIgnoreCase("Uygulamalar")) {
                while (sc.hasNextLine()) {
                    apps = sc.nextLine().toString().split(" ");
                    if (!apps[0].trim().equalsIgnoreCase("Kişiler")) {
                        Application app = new Application(apps[0], apps[1], Double.parseDouble(apps[2]));
                        applicationList.add(app);
                    }
                    else {
                        while (sc.hasNext()) {
                            apps = sc.nextLine().split(" ");
                            Person person = new Person(apps[0], apps[1], apps[2]);
                            personList.add(person);
                        }
                    }
                }

            }
            //  } while (apps != null);




            System.out.println("Geri yükleme tamamlandı.");

            System.out.println("**************************************");


        } catch (
                FileNotFoundException e) {
            throw new Exception("Dosya Bulunamadı.");
        }
    }


        public void backUp () {
            try {
                FileWriter fileWriter = new FileWriter("Backup.txt", false);

                //yama işlemleri
                fileWriter.write("Uygulamalar \n");
                for (Application app : applicationList) {
                    fileWriter.write(app.getAppName() + " " + app.getVersion() + " " + app.getDimension() + "\n");
                }
                fileWriter.write("Kişiler\n");
                for (Person person : personList) {
                    fileWriter.write(person.getPersonName() + " " + person.getPhoneNumber() + " " + person.getEmail() + "\n");
                }
                fileWriter.close();
                System.out.println("Yedekleme başarıyla tamamlandı");
                System.out.println("**************************************");
            } catch (IOException e) {
                System.out.println("Yedekleme işleminde bir hata oluştu.");
                System.out.println("**************************************");
                e.printStackTrace();
            }
        }


    }
