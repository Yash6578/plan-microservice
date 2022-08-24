package in.ashokit.planmicroservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PLAN_MASTER")
@Data
public class Plan {

    /**
     Business Need
     */
    @Id
    @GeneratedValue
    @Column(name = "PLAN_ID")
    private Long id;

    @Column(name = "PLAN_NAME")
    private String name;

    @Column(name = "PLAN_END_DATE")
    private Date startDate;

    @Column(name = "PLAN_START_DATE")
    private Date endDate;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "ACTIVE_SW")
    private String ActiveSw;

    /**
     For Tracking Purpose
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", insertable = false)
    private LocalDateTime updatedDate;

}
