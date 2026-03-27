package gitHubApi.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    private final KafkaTemplate<String, String> template;

    public EventPublisher(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void publish(String repoId) {
        template.send("repo-created", repoId);
    }
}
