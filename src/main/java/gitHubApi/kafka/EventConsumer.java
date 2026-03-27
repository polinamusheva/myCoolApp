package gitHubApi.kafka;

import gitHubApi.entity.RepoEntity;
import gitHubApi.repository.RepoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    private final RepoRepository repository;

    public EventConsumer(RepoRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "repo-created", groupId = "repos")
    public void consume(String repoId) {
        RepoEntity repo = new RepoEntity(repoId, "from-kafka", "unknown") {
        };
        repository.save(repo);
    }
}
