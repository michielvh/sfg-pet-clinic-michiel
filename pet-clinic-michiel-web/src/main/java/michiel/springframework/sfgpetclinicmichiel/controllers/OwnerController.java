package michiel.springframework.sfgpetclinicmichiel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import michiel.springframework.sfgpetclinicmichiel.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    //can never be changed
    private final OwnerService ownerService;

    // Constructor Injection
    public OwnerController(OwnerService ownerService) {

        this.ownerService = ownerService;
    }

    @RequestMapping({ "", "/", "/index", "/index.html" })
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
