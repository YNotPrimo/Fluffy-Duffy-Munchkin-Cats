package primo.fdmc.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import primo.fdmc.domains.binding.CatCreateBindingModel;
import primo.fdmc.domains.entities.Cat;
import primo.fdmc.domains.service.CatServiceModel;
import primo.fdmc.repositories.CatRepository;
import primo.fdmc.services.CatService;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/cats")
public class CatController {
    private final ModelMapper modelMapper;
    private final CatService catService;
    private final CatRepository catRepository;

    public CatController(ModelMapper modelMapper, CatService catService, CatRepository catRepository) {
        this.modelMapper = modelMapper;
        this.catService = catService;
        this.catRepository = catRepository;
    }

    @GetMapping("/create")
    public String createCat(){
        return "create-cat.html";
    }

    @PostMapping("/create")
    public String getCatInformation(@Valid @ModelAttribute("catCreateBindingModel") CatCreateBindingModel catCreateBindingModel){

        this.catService
                .register(
                        modelMapper
                .map(catCreateBindingModel, CatServiceModel.class));
        return "redirect:/";
    }


    @GetMapping("/all")
    public ModelAndView getAllCats(ModelAndView modelAndView){
        modelAndView.addObject("cats", this.catService.getAllCats());
        modelAndView.setViewName("cat-all");
        return modelAndView;
    }
}
