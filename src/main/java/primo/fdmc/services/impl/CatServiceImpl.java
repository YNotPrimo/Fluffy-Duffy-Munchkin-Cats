package primo.fdmc.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import primo.fdmc.domains.entities.Cat;
import primo.fdmc.domains.service.CatServiceModel;
import primo.fdmc.domains.view.CatViewModel;
import primo.fdmc.repositories.CatRepository;
import primo.fdmc.services.CatService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService {
    private final ModelMapper modelMapper;
    private final CatRepository catRepository;


    public CatServiceImpl(ModelMapper modelMapper, CatRepository catRepository) {
        this.modelMapper = modelMapper;
        this.catRepository = catRepository;
    }

    @Override
    public void register(CatServiceModel catServiceModel) {
        this.modelMapper
                .map(this.catRepository
                                .saveAndFlush(this.modelMapper
                                        .map(catServiceModel, Cat.class)),
                        CatServiceModel.class
                );
    }

    @Override
    public Set<CatViewModel> getAllCats() {
        return this.catRepository
                .findAll()
                .stream()
                .map(cat -> this.modelMapper.map(cat, CatViewModel.class))
                .collect(Collectors.toSet());
    }
}

