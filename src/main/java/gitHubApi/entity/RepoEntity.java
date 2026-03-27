package gitHubApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "repos")
public class RepoEntity {

    @Id
    private String id;

    private String name;

    private String owner;

    // Constructors
    public RepoEntity() {
    }

    public RepoEntity(String id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

}
