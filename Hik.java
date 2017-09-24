import okhttp3.*;

import java.io.FileOutputStream;

public class Hik {
    String ip;
    String auth = "/?auth=YWRtaW46MTEKYOBA";
    int verbose = 0;

    public Hik(String i) {
        ip = "http://" + i;
    }

    public void setVerbLevel(int v) {
        verbose = v;
    }

    public String devInfo() throws Exception {

        String url = ip + "/System/deviceInfo" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();

        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return "";
        }

        return r.body().string();
    }


    public boolean test4expl() throws Exception {

        String url = ip + "/Security/users" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();
        return r.code() == 200;
    }


    public String getHDD() throws Exception {

        String url = ip + "/ContentMgmt/storage" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();

        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return "";
        }

        return r.body().string();

    }

    public boolean addUser(String name, String id) throws Exception {

        String url = ip + "/Security/users/" + id + "/" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).put(RequestBody.create(MediaType.parse("xml version=1.0 encoding=UTF-8"), XML.user(name, id))).build()).execute();
        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return true;
        }

        return r.isSuccessful();

    }


    public boolean deleteUser(String num) throws Exception {

        String url = ip + "/Security/users/" + num + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).delete().build()).execute();
        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return true;
        }

        return r.isSuccessful();
    }


    public boolean downloadConfig() throws Exception {

        String url = ip + "/System/configurationFile" + auth;

        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();

        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return true;
        }
        FileOutputStream fw = new FileOutputStream(ip.substring(6, ip.length())+".ConfFile");
        fw.write(r.body().bytes());
        fw.flush();
        fw.close();

        return r.isSuccessful();

    }

//    public void uploadConfig() throws Exception {
//
//        String url = ip + "/System/configurationFile" + auth;
//        OkHttpClient cli = new OkHttpClient();
//        Response r = cli.newCall(new Request.Builder().url(url).put(RequestBody.create(MediaType.parse("application/binary; charset=UTF-8"), new File(path + "/configs/" + ip.substring(6, ip.length())))).build()).execute();
//        if (verbose > 1)
//            SystemOut.print(r);
//
//    }

    public String getusers() throws Exception {

        String url = ip + "/Security/users" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();

        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return "";
        }
        return r.body().string();
    }


    public boolean resetadmin() throws Exception {

        String url = ip + "/Security/users" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).put(RequestBody.create(MediaType.parse("xml version=1.0 encoding=UTF-8"), XML.admin())).build()).execute();

        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return true;
        }
        return r.isSuccessful();
    }


    public String getChanels() throws Exception {

        String url = ip + "/Streaming/channels" + auth;
        OkHttpClient cli = new OkHttpClient();
        Response r = cli.newCall(new Request.Builder().url(url).get().build()).execute();
        if (verbose > 1)
            SystemOut.print("Message\n" + r);
        if (verbose > 2)
            SystemOut.print("Headers\n" + r.headers());
        if (verbose > 3) {
            SystemOut.print("Body\n" + r.body().string());
            return "";
        }

        return r.body().string();
    }


}
