package no.hvl.dat110.ac.rest;

import com.google.gson.Gson;

import java.util.Optional;

import static spark.Spark.*;

/**
 * Hello world!
 */
public class App {

    static AccessLog accesslog = null;
    static AccessCode accesscode = null;

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        // objects for data stored in the service

        accesslog = new AccessLog();
        accesscode = new AccessCode();

        after((req, res) -> {
            res.type("application/json");
        });

        // for basic testing purposes
        get("/accessdevice/hello", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson("IoT Access Control Device");
        });


        post("/accessdevice/log/", (req, res) -> {
            String json = req.body();
            AccessMessage message = AccessMessage.fromJson(json);
            Integer id = accesslog.add(message.getMessage());
            return accesslog.get(id).get().toJson();
        });

        get("/accessdevice/log/", (req, res) -> accesslog.toJson());

        get("/accessdevice/log/:id", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Optional<AccessEntry> entry = accesslog.get(id);
            if (entry.isPresent())
                return entry.get().toJson();
            else {
                Gson gson = new Gson();
                return gson.toJson("Elementet finnes ikke!");
            }
        });

        put("/accessdevice/code", (req, res) -> {
            AccessCode code = AccessCode.fromJson(req.body());
            accesscode.setAccesscode(code.getAccesscode());
            return code.toJson();
        });

        get("/accessdevice/code", (req,res) -> accesscode.toJson());

        delete("/accessdevice/log/", (req,res) -> {
            accesslog.clear();
            return accesslog.toJson();
        });


    }

}
