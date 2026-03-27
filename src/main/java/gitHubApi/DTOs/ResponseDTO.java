package gitHubApi.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {
    public String login;
    public int id;
    public String node_id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public String user_view_type;
    public boolean site_admin;
    public String name;
    public Object company;
    public String blog;
    public String location;
    public Object email;
    public boolean hireable;
    public String bio;
    public Object twitter_username;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public Date created_at;
    public Date updated_at;
    public int private_gists;
    public int total_private_repos;
    public int owned_private_repos;
    public int disk_usage;
    public int collaborators;
    public boolean two_factor_authentication;
    public PlanDTO plan;

}
