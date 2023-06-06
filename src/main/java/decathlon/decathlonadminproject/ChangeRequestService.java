package decathlon.decathlonadminproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeRequestService {

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    public List<ChangeRequest> getAllRequests() {
        return changeRequestRepository.findAll();
    }

    public ChangeRequest getRequestById(Long id) {
        Optional<ChangeRequest> optionalChangeRequest = changeRequestRepository.findById(id);
        return optionalChangeRequest.orElse(null);
    }

    public void createRequest(ChangeRequest changeRequest) {
        changeRequestRepository.save(changeRequest);
    }

    public void updateRequest(ChangeRequest changeRequest) {
        changeRequestRepository.save(changeRequest);
    }

    public void deleteRequest(ChangeRequest changeRequest) {
        changeRequestRepository.delete(changeRequest);
    }
}
