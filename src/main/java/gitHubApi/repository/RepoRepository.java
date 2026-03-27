package gitHubApi.repository;

import gitHubApi.entity.RepoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<RepoEntity, String> {

}
