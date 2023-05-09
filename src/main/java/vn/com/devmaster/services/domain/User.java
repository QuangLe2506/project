package vn.com.devmaster.services.domain;

import lombok.*;
import org.hibernate.Hibernate;
import vn.com.devmaster.services.domain.enums.RoleEnum;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "account")
    private String account;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}