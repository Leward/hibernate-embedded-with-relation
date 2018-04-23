package eu.leward.hibernate.embeddedwithrelation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class PlayerProfile {
    private String nickname;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<PlayerRole> roles = new HashSet<>();

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<PlayerRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<PlayerRole> roles) {
        this.roles = roles;
    }

    public void addRole(PlayerRole role) {
        roles.add(role);
    }
}
