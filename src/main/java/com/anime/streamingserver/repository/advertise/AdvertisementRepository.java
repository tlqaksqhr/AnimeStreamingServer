package com.anime.streamingserver.repository.advertise;



import com.anime.streamingserver.entity.advertise.Advertisement;

import java.util.List;

public interface AdvertisementRepository {
    List<Advertisement> getAllAdvertisement();
    List<Advertisement> getAdvertiseTop5ByRandom();

    void saveAdvertisement(Advertisement advertisement);
    void updateAdvertisement(Advertisement advertisement);
    void deleteAdvertisement(Advertisement advertisement);
}
