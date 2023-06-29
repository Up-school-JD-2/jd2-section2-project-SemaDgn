import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneManagementApp phoneManagementApp = new PhoneManagementApp();
        Application app1 = new Application("ins", "1.1", 1024);
        phoneManagementApp.applicationList.add(app1);

        Person person1 = new Person("Sema", "0534-703-40-33", "semasanli34@gmail.com");
        Person person2 = new Person("Yüsra", "0532-745-40-58", "yusradogan@gmail.com");
        phoneManagementApp.personList.add(person1);
        phoneManagementApp.personList.add(person2);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            printMenu();
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz:");
            try {


                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Uygulama Adı: ");
                        String appName = sc.next();
                        System.out.print("Uygulama Versiyon: ");
                        String version = sc.next();
                        System.out.print("Uygulama Boyutu (MB): ");
                        Integer dimension = sc.nextInt();
                        phoneManagementApp.appAddToPhone(new Application(appName, version, dimension));

                        System.out.println("Uygulama başarıyla eklendi.");
                        System.out.println("--------------------------------");

                    }
                    case 2 -> {
                        System.out.print("Güncellemek istediğiniz uygulama adını giriniz: ");
                        String appName = sc.next().trim();
                        if (!appName.isEmpty()) {
                            if (phoneManagementApp.checkApp(appName)) {
                                System.out.print("Güncellenecek Ad: ");
                                String _appName = sc.next().trim();
                                System.out.print("Güncellenecek Versiyon: ");
                                String version = sc.next().trim();
                                System.out.print("Güncellenecek Boyut: ");
                                Integer dimension = sc.nextInt();
                                Application newApp = new Application(_appName, version, dimension);
                                phoneManagementApp.appUpdateToPhone(appName, newApp);
                                System.out.println("Uygulama başarıyla güncellendi.");
                                System.out.println("--------------------------------");

                            } else {
                                System.out.println("Girdiğiniz isimde uygulama bulunmadı.");
                                System.out.println("--------------------------------");

                            }

                        } else {
                            System.out.println("Güncellenecek uygulama adı boş geçilemez.");
                            System.out.println("--------------------------------");

                        }

                    }
                    case 3 -> {
                        System.out.print("Silmek istediğiniz uygulama adını giriniz: ");
                        String appName = sc.next().trim();
                        if (!appName.isEmpty()) {
                            if (phoneManagementApp.checkApp(appName)) {
                                boolean removeResult = phoneManagementApp.appRemoveToPhone(appName);
                                if (removeResult) {
                                    System.out.println("Silme işlemi başarılı.");
                                    System.out.println("--------------------------------");

                                } else {
                                    System.out.println("Silme işlemi sırasında bir hata oluştu.");
                                    System.out.println("--------------------------------");

                                }
                            } else {
                                System.out.println("Girdiğiniz isimde uygulama bulunmadı.");
                                System.out.println("--------------------------------");

                            }

                        } else {
                            System.out.println("Silinecek uygulama adı boş geçilemez.");
                            System.out.println("--------------------------------");

                        }

                    }
                    case 4 -> {
                        System.out.print("Kişi Adı: ");
                        String personName = sc.next();
                        System.out.print("Kişi Telefon (05**-***-**-**): ");
                        String phoneNumber = sc.next();
                        System.out.print("Kişi e-Mai: ");
                        String eMail = sc.next();
                        phoneManagementApp.addPersontoPhone(new Person(personName, phoneNumber, eMail));

                        System.out.println("Kişi başarıyla eklendi.");
                        System.out.println("--------------------------------");
                    }
                    case 5 -> {
                        System.out.print("Güncellemek istediğiniz kişi adını giriniz: ");
                        String personName = sc.next().trim();
                        if (!personName.isEmpty()) {
                            if (phoneManagementApp.checkPerson(personName)) {
                                System.out.print("Güncellenecek Ad: ");
                                String _personName = sc.next().trim();
                                System.out.print("Güncellenecek Telefon (05**-***-**-**): ");
                                String phoneNumber = sc.next().trim();
                                System.out.print("Güncellenecek e-Mail: ");
                                String eMail = sc.next();
                                Person newPerson = new Person(_personName, phoneNumber, eMail);
                                phoneManagementApp.personUpdateToPhone(personName, newPerson);
                                System.out.println("Kişi bilgileri başarıyla güncellendi.");
                                System.out.println("--------------------------------");

                            } else {
                                System.out.println("Girdiğiniz isimde kişi bulunamadı.");
                                System.out.println("--------------------------------");

                            }

                        } else {
                            System.out.println("Güncellenecek kişi adı boş geçilemez.");
                            System.out.println("--------------------------------");

                        }

                    }
                    case 6 -> {
                        System.out.print("Silmek istediğiniz kişi adını giriniz: ");
                        String personName = sc.next().trim();
                        if (!personName.isEmpty()) {
                            if (phoneManagementApp.checkPerson(personName)) {
                                boolean removeResult = phoneManagementApp.personRemoveToPhone(personName);
                                if (removeResult) {
                                    System.out.println("Silme işlemi başarılı.");
                                    System.out.println("--------------------------------");

                                } else {
                                    System.out.println("Silme işlemi sırasında bir hata oluştu.");
                                    System.out.println("--------------------------------");

                                }
                            } else {
                                System.out.println("Girdiğiniz isimde kişi bulunamadı.");
                                System.out.println("--------------------------------");

                            }

                        } else {
                            System.out.println("Silinecek uygulama adı boş geçilemez.");
                            System.out.println("--------------------------------");

                        }

                    }
                    case 7 -> {

                        System.out.print("Aramak istediğiniz kişinin adını giriniz: ");
                        String personName = sc.next().trim();

                        if (!personName.isEmpty()) {
                            Person person = phoneManagementApp.getPerson(personName);
                            if (person != null) {
                                System.out.println("Aradığınız Kişi Bilgileri");
                                System.out.println("Ad-Soyad: " + person.getPersonName());
                                System.out.println("Telefon: " + person.getPhoneNumber());
                                System.out.println("e-Mail: " + person.getEmail());
                                System.out.println("--------------------------------");

                            } else {
                                System.out.println("Girdiğiniz isimde kişi bulunmadı.");
                                System.out.println("--------------------------------");

                            }

                        } else {
                            System.out.println("Aranacak kişi adı boş geçilemez.");
                            System.out.println("--------------------------------");
                        }

                    }
                    case 8 -> {
                        phoneManagementApp.backUp();
                    }
                    case 9 -> {
                        phoneManagementApp.restore();
                    }
                    case 10 -> {
                        System.out.println(DomainConstant.phone.toString());
                    }
                    case 11 -> {
                        phoneManagementApp.phoneStorageInfo();
                    }
                    case 12 -> {
                        phoneManagementApp.appPrint();
                    }
                    case 13 -> {
                        phoneManagementApp.personPrint();
                    }
                    case -1 -> {
                        System.exit(0);
                    }

                }
            } catch (Exception e) {
                System.out.println("Girmiş olduğunuz rakamı kontrol ediniz.");
                System.out.println("Mesaj: " + e.getMessage());
                System.out.println("--------------------------------");
            }

        } while (choice != -1);

    }

    private static void printMenu() {
        System.out.println("##### Menu #####");
        System.out.println("1: Uygulama Ekleme");
        System.out.println("2: Uygulama Güncelleme");
        System.out.println("3: Uygulama Silme");
        System.out.println("4: Kişi Ekleme");
        System.out.println("5: Kişi Güncelleme");
        System.out.println("6: Kişi Silme");
        System.out.println("7: Kişi Ara");
        System.out.println("8: Bilgileri Yedekle");

        System.out.println("9: Bilgileri Dosyadan Geri Yükle");

        System.out.println("10: Telefon Bilgilerini Göster");
        System.out.println("11: Telefon Depolama Bilgilerini Göster");
        System.out.println("12: Uygulama Listesi");
        System.out.println("13: Kişi Listesi");
        System.out.println("-1: Çıkış \n");
    }

}
