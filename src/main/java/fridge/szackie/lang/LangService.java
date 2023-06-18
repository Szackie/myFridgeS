package fridge.szackie.lang;


import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
class LangService {

    private LangRepository langRepository;

    LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    List<LangDTO> findAll() {

        return langRepository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
    }

}
