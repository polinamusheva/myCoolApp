package gitHubApi.KafkaIntegration;

import gitHubApi.entity.RepoEntity;
import gitHubApi.kafka.EventPublisher;
import gitHubApi.repository.RepoRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.testcontainers.shaded.org.awaitility.Awaitility;

import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class KafkaTestTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private RepoRepository repoRepository;

    @Test
    public void shouldConsumeEventAndPersistRepo() {

        // given
        String repoId = "repo-123";

        // when → send Kafka event
        eventPublisher.publish(repoId);

        // then → wait and verify DB
        Awaitility.await()
                .atMost(Duration.ofSeconds(5))
                .untilAsserted(() -> {

                    Optional<RepoEntity> repo = repoRepository.findById(repoId);

                    assertThat(repo).isPresent();
                });
    }
}

