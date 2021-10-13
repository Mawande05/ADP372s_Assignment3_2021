package za.ac.cput.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.services.GuestService;

@RestController
@RequestMapping
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Guest create (Guest guest){
        Guest newGuest = GuestFactory.createGuest(guest.getGuestAmount());
        return guestService.create(newGuest);
    }

    @GetMapping("/read")
    public Guest read(@RequestBody Guest guest){
        return guestService.read(guest.getGuestAmount());
    }

    @PostMapping("/update")
    public Guest update(@RequestBody Guest guest){
        return guestService.update(guest);
    }

    @PostMapping
    public String delete(@RequestBody Guest guest){
        if(guestService.delete(guest.getGuestAmount()))
            return "Guest deleted successfully";

        else
            return "Guest could not be deleted";

    }
}