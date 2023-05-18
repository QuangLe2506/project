package vn.com.devmaster.services.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "khoa")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Khoa extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ten_khoa")
    private String tenKhoa;

    @Column(name = "ma_khoa")
    private String maKhoa;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building buildingId;
}
