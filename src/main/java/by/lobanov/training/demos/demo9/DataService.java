package by.lobanov.training.demos.demo9;

import lombok.RequiredArgsConstructor;

import java.rmi.AccessException;
import java.util.UUID;

@RequiredArgsConstructor
public class DataService {

    private final AccessService accessService;
    private final DataRepository dataRepository;

    public Data get(String uid) throws AccessException {
        try {
            accessService.checkRead();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AccessException("Access denied");
        }

        return dataRepository.get(uid);
    }

    public Data create(String name) throws AccessException {
        try {
            accessService.checkWrite();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AccessException("Access denied");
        }
        return dataRepository.save(new Data(
                UUID.randomUUID(),
                name
        ));
    }
}

 record Data(
        UUID uid,
        String name
) {
}

 interface DataRepository {
    Data save(Data data);
    Data get(String uid);
}

 interface AccessService {
    void checkRead();
    void checkWrite();
}