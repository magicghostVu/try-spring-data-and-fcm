package pack.controllers;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pack.logs.LoggingService;
import pack.model.Contact;
import pack.services.ContactService;

import java.util.List;

/**
 * Created by Fresher on 27/06/2018.
 */
@RestController
public class ContactController {


    @Autowired
    private LoggingService loggingService;

    public ContactController() {
        //LoggingService.getInstance().getLogger().info("ContactController init...");
    }

    @Autowired
    private ContactService contactService;

    private Gson gson = new Gson();

    @RequestMapping(value = "/all-contact", method = RequestMethod.POST)
    public String getAllContact() {
        String res = gson.toJson(contactService.findAll());
        return res;
    }

    @RequestMapping(value = "/add-contact", method = RequestMethod.POST, consumes = "application/json")
    public String addAContact(@RequestBody String jsonContact) {
        Contact c = new Contact();
        c.setEmail("magicghost.vu@gmail.com");
        c.setName("Vũ Hồng Phú");
        c.setPhone("01689357005");
        c.setId(1);
        contactService.save(c);
        return "SUCCESS";
    }

    @RequestMapping(value = "/search-contact", method = RequestMethod.POST, consumes = "application/json")
    public String searchContact(@RequestBody String jsonQuery) {

        loggingService.getLogger().info("query is {}", jsonQuery);

        JSONObject jsonObject = new JSONObject(jsonQuery);


        String name= jsonObject.getString("name");

        List<Contact> lc= contactService.search(name);



        return gson.toJson(lc);
    }


}
