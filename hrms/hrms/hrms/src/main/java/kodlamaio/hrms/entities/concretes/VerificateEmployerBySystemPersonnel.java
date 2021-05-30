package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers_verification_admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificateEmployerBySystemPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="employer_id")
    private int employerId;

    @Column(name="admin_id")
    private int adminlId;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt = LocalDate.now();

    @Column(name="is_verified", columnDefinition = "boolean default true")
    private boolean isVerified = true;

    @Column(name="is_deleted", columnDefinition = "boolean default true")
    private boolean isDeleted=false;
}
