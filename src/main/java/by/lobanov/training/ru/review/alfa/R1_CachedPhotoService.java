package by.lobanov.training.ru.review.alfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

public class R1_CachedPhotoService {
/*
    @Component
    public final class CachedPhotoService {
        public static final String RESIZED_PHOTO_CACHE_NAME = "RESIZED_PHOTO_CACHE_NAME";
        @Autowired
        private PhotoRepository photoRepository;
        @Autowired
        private PhotoValidationService photoValidationService;
        @Autowired
        private PhotoOperations photoOperations;

        @Cacheable(cacheNames = RESIZED_PHOTO_CACHE_NAME)
        public PhotoDTO resizePhoto(String photoId, int width, int height) {
            photoValidationService.validateSize(width, height);
            Photo photo = photoRepository.findById(photoId);
            PhotoDto photoDto = ConvertionUtils.convert(photo);
            var resizedPhoto = photoOperations.resize(photoDto, width, height);
            return resizedPhoto;
        }
        public PhotoDTO iconizePhoto(String photoId) {
            return resizePhoto(photoId, 100, 100);
        }
    }
*/
}
