/**
 * Created by root on 9/21/17.
 */
public class Parser {
    public static String users(String r) {


        String users = "";


        while (r.indexOf("userName") != -1) {
            users += "==========================";
            users += "\nNickname: ";
            users += r.substring(r.indexOf("userName") + 9, r.indexOf("</userName>"));
            users += "\ntype: ";
            users += r.substring(r.indexOf("userLevel") + 10, r.indexOf("</userLevel>"));

            users += "\nid: ";
            users += r.substring(r.indexOf("<id>") + 4, r.indexOf("</id>"));
            users += "\n";
            r = r.substring(r.indexOf("</userLevel>") + 11);
        }

        users += "===========================";


        return users;
    }

    public static String device(String r) {


        String di = "Cam name <" + parse(r, "deviceName", "</deviceName") + ">";
        di += "\nModel: " + parse(r, "model", "</model");
        di += "\nFirmware: " + parse(r, "firmwareVersion", "</firmwareVersion");
        return di;


    }


    public static String HDD(String r) {


        if (r.indexOf("<id>1") != -1) {

            return "HDD size: "+parse(r,"capacity","</capacity");
        }
        return "Hdd not found";

    }

    public static String getChannels(String r) {

        String a = "";

        while (r.indexOf("<id>") > 0) {


            String chname = "id: " + parse(r, "videoInputChannelID", "</videoInputChannelID");

            if (a.indexOf(chname) == -1) {

                chname += "\nName:" + parse(r, "channelName", "</channelName");
                chname += "\nRes: " + parse(r, "videoResolutionWidth", "</videoResolutionWidth") + "x" + parse(r, "videoResolutionHeight", "</videoResolutionHeight");
                a += chname;
            }

            r = r.substring(r.indexOf("</StreamingChannel") + 18);

        }

        return a;

    }

    static String parse(String source, String a, String b) {

        return source.substring(source.indexOf(a) + a.length() + 1, source.indexOf(b));

    }

}
