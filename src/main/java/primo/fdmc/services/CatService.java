package primo.fdmc.services;

import primo.fdmc.domains.service.CatServiceModel;
import primo.fdmc.domains.view.CatViewModel;

import java.util.Set;

public interface CatService {
    void register(CatServiceModel catServiceModel);

    Set<CatViewModel> getAllCats();
}
