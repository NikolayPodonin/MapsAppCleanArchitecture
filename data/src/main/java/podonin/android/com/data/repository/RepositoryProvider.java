package podonin.android.com.data.repository;

import podonin.android.com.domain.repository.PlacesRepository;

public class RepositoryProvider {
    private RepositoryProvider(){}

    private static PlacesRepositoryImpl sRepository;

    public static PlacesRepository providePlacesRepository() {
        if (sRepository == null) {
            sRepository = new PlacesRepositoryImpl();
        }
        return sRepository;
    }
}
