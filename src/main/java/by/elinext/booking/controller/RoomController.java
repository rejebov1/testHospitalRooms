package by.elinext.booking.controller;

import by.elinext.booking.model.Room;
import by.elinext.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {
    private RoomService roomService;

    @Autowired
    @Qualifier(value = "roomService")
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "room", method = RequestMethod.GET)
    public String roomsList(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("roomList", this.roomService.roomList());

        return "room";
    }

    @RequestMapping(value = "room/add", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("room") Room room) {
        roomService.addRoom(room);
        return "redirect:/room";
    }

    @RequestMapping("/remove/{id}")
    public String removeRooms(@PathVariable("id") Long id) {
        this.roomService.removeRoom(id);

        return "redirect:/room";
    }

    @RequestMapping("roomId/{id}")
    public String roomId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("room", this.roomService.getById(id));

        return "roomId";
    }

    @RequestMapping("roomdetails/{id}")
    public String roomDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("room", this.roomService.getById(id));

        return "roomdetails";
    }
}
